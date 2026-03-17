package laboratorio.desafios.remessasemdeposito;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import estruturas.lineares.IFila;
import estruturas.lineares.IPilha;
import estruturas.lineares.dinamicas.fila.FilaComListaDuplamenteEncadeada;
import estruturas.lineares.dinamicas.pilha.PilhaComListaSimplesmenteEncadeada;

public class GerenciadorRemessaDeposito implements IGerenciadorRemessaDeposito {

    // Mapa para o estoque: Chave = ID (String), Valor = Pilha de itens
    // LinkedHashMap mantém a ordem de inserção das chaves (CebolaRoxa, Batata, etc.)
    private Map<String, IPilha<IItemEstoque>> estoque;

    // Fila para guardar as remessas que aguardam processamento
    private IFila<IItemEstoque[]> filaDeRemessas;

    public GerenciadorRemessaDeposito() {
        this.estoque = new LinkedHashMap<>();
        this.filaDeRemessas = new FilaComListaDuplamenteEncadeada<>();
    }

    @Override
    public void receberRemessa(IItemEstoque[] remessa) {
        // As remessas entram na fila na ordem de chegada
        filaDeRemessas.enfileirar(remessa);
    }

    @Override
    public void processarTodasRemessas() {
        // Enquanto houver remessas na fila, processa uma por uma (FIFO)
        while (!filaDeRemessas.estaVazia()) {
            IItemEstoque[] remessaAtual = filaDeRemessas.desenfileirar();
            processarUmaUnicaRemessa(remessaAtual);
        }
    }

    @Override
    public void processarUmaUnicaRemessa(IItemEstoque[] remessa) {
        // 1. Ordenação por Inserção (Insertion Sort) no array da remessa
        // Ordenamos por data de validade para organizar a entrada
        for (int i = 1; i < remessa.length; i++) {
            IItemEstoque chave = remessa[i];
            int j = i - 1;

            // Move itens com data POSTERIOR à chave para frente (ordem crescente de data)
            while (j >= 0 && remessa[j].obterDataValidade().isAfter(chave.obterDataValidade())) {
                remessa[j + 1] = remessa[j];
                j = j - 1;
            }
            remessa[j + 1] = chave;
        }

        // 2. Inserção no Estoque (Pilha)
        for (IItemEstoque item : remessa) {
            String id = item.obterID();

            // Se não existe pilha para este produto, cria uma nova
            if (!estoque.containsKey(id)) {
                // Instancia a pilha concreta
                estoque.put(id, new PilhaComListaSimplesmenteEncadeada<>());
            }

            IPilha<IItemEstoque> pilhaDoProduto = estoque.get(id);
            inserirNaPilhaOrdenada(pilhaDoProduto, item);
        }
    }

    /**
     * Método auxiliar para inserir na Pilha mantendo a data mais próxima (urgente) no TOPO.
     * Estratégia: Usamos uma pilha auxiliar.
     * Retiramos do topo da pilha principal tudo que for MAIS URGENTE (data menor) que o novo item.
     * Colocamos o novo item.
     * Devolvemos os itens urgentes para cima do novo item.
     */
    private void inserirNaPilhaOrdenada(IPilha<IItemEstoque> pilhaPrincipal, IItemEstoque novoItem) {
        // Instancia pilha auxiliar do mesmo tipo
        IPilha<IItemEstoque> pilhaAuxiliar = new PilhaComListaSimplesmenteEncadeada<>();

        // Enquanto o topo for "melhor" (data anterior/menor) que o novo item, move para aux
        // Ex: Topo 2026-01. Novo 2026-05. Topo deve continuar em cima. Removemos o topo para inserir o novo embaixo.
        while (!pilhaPrincipal.estaVazia() &&
                pilhaPrincipal.obterTopo().obterDataValidade().isBefore(novoItem.obterDataValidade())) {
            pilhaAuxiliar.empilhar(pilhaPrincipal.desempilhar());
        }

        // Caso de datas iguais ou se o novo for mais urgente que o atual topo:
        // Se a pilhaPrincipal tiver data 2028. Novo é 2026. Loop acima não roda. Novo entra em cima (Topo). Correto.

        pilhaPrincipal.empilhar(novoItem);

        // Devolve os itens da auxiliar para a principal
        while (!pilhaAuxiliar.estaVazia()) {
            pilhaPrincipal.empilhar(pilhaAuxiliar.desempilhar());
        }
    }

    @Override
    public String obterStatusArmazenamento() {
        if (estoque.isEmpty()) {
            return ""; // Retorna vazio para o App tratar com "NÃO"
        }

        StringBuilder sb = new StringBuilder();
        int contadorMap = 0;

        for (Map.Entry<String, IPilha<IItemEstoque>> entry : estoque.entrySet()) {
            sb.append(entry.getKey()).append(": "); // Ex: CebolaRoxa:

            IPilha<IItemEstoque> pilhaPrincipal = entry.getValue();

            // Pilha auxiliar para guardar os itens enquanto lemos
            IPilha<IItemEstoque> pilhaAux = new PilhaComListaSimplesmenteEncadeada<>();

            // 1. Desempilha tudo para ler (isso inverte a ordem temporariamente)
            while (!pilhaPrincipal.estaVazia()) {
                IItemEstoque item = pilhaPrincipal.desempilhar();
                sb.append(item.toString());

                pilhaAux.empilhar(item); // Guarda na auxiliar para restaurar depois

                if (!pilhaPrincipal.estaVazia()) {
                    sb.append(" -> ");
                }
            }

            // 2. Restaura a pilha original (trazendo de volta da auxiliar)
            while (!pilhaAux.estaVazia()) {
                pilhaPrincipal.empilhar(pilhaAux.desempilhar());
            }

            // Adiciona quebra de linha se não for o último produto do mapa
            if (++contadorMap < estoque.size()) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public IItemEstoque recuperarProximoItemDaRemessa(String ID) {
        // Busca a pilha correspondente ao ID
        if (estoque.containsKey(ID)) {
            IPilha<IItemEstoque> pilha = estoque.get(ID);

            // Como nossa inserção já garante que a data mais próxima está no topo,
            // basta desempilhar.
            if (!pilha.estaVazia()) {
                return pilha.desempilhar();
            }
        }
        return null;
    }

    @Override
    public boolean temRemessasRecebidasPendentesDeProcessamento() {
        return !filaDeRemessas.estaVazia();
    }

}