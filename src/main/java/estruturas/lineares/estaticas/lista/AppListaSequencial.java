package estruturas.lineares.estaticas.lista;

public class AppListaSequencial {

    public static void main(String[] args) {

        // 1. Criar lista com capacidade 5
        ListaSequencial<Integer> lista = new ListaSequencial<>(5);
        System.out.println("1. Lista criada com capacidade 5");
        System.out.println("   Estado: " + lista.imprimir());
        System.out.println("   Tamanho: " + lista.tamanho());
        System.out.println("   Vazia: " + lista.estaVazia());
        System.out.println();

        // 2. Testar inserir(elemento, posicao)
        System.out.println("2. Inserindo elementos com inserir(elemento, posicao):");
        lista.inserir(10, 0);
        System.out.println("   Inserir 10 na posição 0: " + lista.imprimir());

        lista.inserir(30, 1);
        System.out.println("   Inserir 30 na posição 1: " + lista.imprimir());

        lista.inserir(20, 1);
        System.out.println("   Inserir 20 na posição 1: " + lista.imprimir());
        System.out.println("   Tamanho atual: " + lista.tamanho());
        System.out.println();

        // 3. Testar atualizar(posicao, elemento)
        System.out.println("3. Testando atualizar(posicao, elemento):");
        lista.atualizar(0, 100);
        System.out.println("   Atualizar posição 0 para 100: " + lista.imprimir());

        lista.atualizar(2, 300);
        System.out.println("   Atualizar posição 2 para 300: " + lista.imprimir());
        System.out.println();

        // 4. Testar remover(posicao)
        System.out.println("4. Testando remover(posicao):");
        Integer removido = lista.remover(1);
        System.out.println("   Remover posição 1: " + lista.imprimir());
        System.out.println("   Elemento removido: " + removido);
        System.out.println("   Tamanho atual: " + lista.tamanho());
        System.out.println();

        // 5. Testar inserirInicio(elemento)
        System.out.println("5. Testando inserirInicio(elemento):");
        lista.inserirInicio(5);
        System.out.println("   Inserir 5 no início: " + lista.imprimir());

        lista.inserirInicio(1);
        System.out.println("   Inserir 1 no início: " + lista.imprimir());
        System.out.println("   Tamanho atual: " + lista.tamanho());
        System.out.println();

        // 6. Testar removerElemento(elemento)
        System.out.println("6. Testando removerElemento(elemento):");
        lista.removerElemento(100);
        System.out.println("   Remover elemento 100: " + lista.imprimir());

        lista.removerElemento(999); // Elemento que não existe
        System.out.println("   Tentar remover elemento 999 (não existe): " + lista.imprimir());
        System.out.println();

        // 7. Testar removerInicio()
        System.out.println("7. Testando removerInicio():");
        lista.removerInicio();
        System.out.println("   Remover início: " + lista.imprimir());

        lista.removerInicio();
        System.out.println("   Remover início novamente: " + lista.imprimir());
        System.out.println();

        // 8. Testar removerFim()
        System.out.println("8. Testando removerFim():");
        // Primeiro vamos adicionar mais elementos
        lista.inserir(40, 0);
        lista.inserir(50, 1);
        lista.inserir(60, 2);
        System.out.println("   Lista após novas inserções: " + lista.imprimir());

        lista.removerFim();
        System.out.println("   Remover fim: " + lista.imprimir());

        lista.removerFim();
        System.out.println("   Remover fim novamente: " + lista.imprimir());
        System.out.println();

        // 9. Testar limpar()
        System.out.println("9. Testando limpar():");
        lista.limpar();
        System.out.println("   Lista após limpar(): " + lista.imprimir());
        System.out.println("   Tamanho: " + lista.tamanho());
        System.out.println("   Vazia: " + lista.estaVazia());
        System.out.println();

        // 10. Testar reutilização após limpeza
        System.out.println("10. Testando reutilização após limpeza:");
        lista.inserirInicio(1000);
        lista.inserir(2000, 1);
        System.out.println("   Inserir 1000 no início e 2000 na posição 1: " + lista.imprimir());
        System.out.println();

        // 11. Testar casos especiais
        System.out.println("11. Testando casos especiais:");

        // Testar com null
        lista.inserir(null, 0);
        System.out.println("   Inserir null na posição 0: " + lista.imprimir());

        // Testar remover elemento null
        lista.removerElemento(null);
        System.out.println("   Remover elemento null: " + lista.imprimir());

        // Estado final
        System.out.println("Estado final da lista: " + lista.imprimir());
        System.out.println("Tamanho final: " + lista.tamanho());
        System.out.println("Está vazia: " + lista.estaVazia());
    }

}
