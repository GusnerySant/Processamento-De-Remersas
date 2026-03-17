package estruturas.lineares.dinamicas.lista;

import java.util.NoSuchElementException;

public class AppListaDuplamenteEncadeada {
    public static void main(String[] args) {
        System.out.println("=== TESTE LISTA DUPLAMENTE ENCADEADA ===\n");

        // 1. Criar uma lista
        System.out.println("1. Criando lista vazia...");
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();
        System.out.println("Lista vazia? " + lista.estaVazia());
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println("Imprimir: " + lista.imprimir());
        System.out.println();

        // 2. Testar adicionar no início
        System.out.println("2. Adicionando elementos no início...");
        lista.adicionarInicio("C");
        lista.adicionarInicio("B");
        lista.adicionarInicio("A");
        System.out.println("Imprimir: " + lista.imprimir());
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println("Lista vazia? " + lista.estaVazia());
        System.out.println();

        // 3. Testar adicionar no fim
        System.out.println("3. Adicionando elementos no fim...");
        lista.adicionarFim("D");
        lista.adicionarFim("E");
        System.out.println("Imprimir: " + lista.imprimir());
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();

        // 4. Testar inserir em posição específica
        System.out.println("4. Inserindo elementos em posições específicas...");
        lista.inserir("X", 2); // Entre B e C
        lista.inserir("Y", 0); // No início
        lista.inserir("Z", lista.tamanho()); // No fim
        System.out.println("Imprimir: " + lista.imprimir());
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();

        // 5. Testar métodos de consulta
        System.out.println("5. Testando métodos de consulta...");
        System.out.println("Elemento na posição 0: " + lista.obter(0));
        System.out.println("Elemento na posição 3: " + lista.obter(3));
        System.out.println("Elemento na posição " + (lista.tamanho()-1) + ": " + lista.obter(lista.tamanho()-1));
        System.out.println("Posição de 'X': " + lista.posicao("X"));
        System.out.println("Posição de 'E': " + lista.posicao("E"));
        System.out.println("Contém 'B'? " + lista.contem("B"));
        System.out.println("Contém 'W'? " + lista.contem("W"));
        System.out.println();

        // 6. Testar atualizar
        System.out.println("6. Atualizando elementos...");
        lista.atualizar(2, "B-NOVO");
        lista.atualizar(4, "C-NOVO");
        System.out.println("Imprimir: " + lista.imprimir());
        System.out.println();

        // 7. Testar remover do início
        System.out.println("7. Removendo do início...");
        String removidoInicio = lista.remover(0);
        System.out.println("Elemento removido do início: " + removidoInicio);
        System.out.println("Imprimir: " + lista.imprimir());
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();

        // 8. Testar remover do fim
        System.out.println("8. Removendo do fim...");
        String removidoFim = lista.remover(lista.tamanho() - 1);
        System.out.println("Elemento removido do fim: " + removidoFim);
        System.out.println("Imprimir: " + lista.imprimir());
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();

        // 9. Testar remover de posição específica
        System.out.println("9. Removendo de posição específica (posição 2)...");
        String removidoPosicao = lista.remover(2);
        System.out.println("Elemento removido da posição 2: " + removidoPosicao);
        System.out.println("Imprimir: " + lista.imprimir());
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();

        // 10. Testar remover por elemento
        System.out.println("10. Removendo elemento 'X'...");
        lista.remover("X");
        System.out.println("Imprimir: " + lista.imprimir());
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();

        // 11. Testar iterador
        System.out.println("11. Testando iterador...");
        System.out.print("Elementos (usando iterador): ");
        for (String elemento : lista) {
            System.out.print(elemento + " ");
        }
        System.out.println("\n");

        // 12. Testar métodos do nó
        System.out.println("12. Testando métodos do nó...");
        INoListaDuplamenteEncadeada<String> primeiroNo = lista.obterPrimeiroNo();
        INoListaDuplamenteEncadeada<String> ultimoNo = lista.obterUltimoNo();
        System.out.println("Primeiro nó: " + (primeiroNo != null ? primeiroNo.obterElemento() : "null"));
        System.out.println("Último nó: " + (ultimoNo != null ? ultimoNo.obterElemento() : "null"));
        System.out.println();

        // 13. Testar limpar
        System.out.println("13. Limpando a lista...");
        lista.limpar();
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println("Lista vazia? " + lista.estaVazia());
        System.out.println("Imprimir: " + lista.imprimir());
        System.out.println();

        // 14. Testar exceções
        System.out.println("14. Testando exceções...");
        try {
            lista.removerInicio();
        } catch (NoSuchElementException e) {
            System.out.println("Exceção ao remover início de lista vazia: " + e.getMessage());
        }

        try {
            lista.obter(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exceção ao obter posição inválida: " + e.getMessage());
        }

        System.out.println("\n=== FIM DO TESTE ===");
    }


}