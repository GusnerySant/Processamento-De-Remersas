package estruturas.lineares.estaticas.lista;

public class AppListaSequencialCapacidadeVariavel {

    public static void main(String[] args) {

        //Lista com capacidade inicial pequena//

        System.out.println("1. Expansão automática de capacidade");
        ListaSequencialCapacidadeVariavel<Integer> lista1 = new ListaSequencialCapacidadeVariavel<>(2);
        System.out.println("   Capacidade inicial: " + lista1.capacidade());
        System.out.println("   Tamanho inicial: " + lista1.tamanho());

        Integer[] lote1 = {10, 20, 30, 40, 50};
        lista1.inserirEmLote(lote1);

        System.out.println("   Após inserir lote de 5 elementos:");
        System.out.println("   Conteúdo: " + lista1.imprimir());
        System.out.println("   Tamanho: " + lista1.tamanho());
        System.out.println("   Capacidade: " + lista1.capacidade());
        System.out.println();

        //Verificação de elementos//

        System.out.println("1.1 Verificação de elementos individuais");
        System.out.println("   Elemento na posição 0: " + lista1.obter(0));
        System.out.println("   Elemento na posição 2: " + lista1.obter(2));
        System.out.println("   Elemento na última posição: " + lista1.obter(lista1.tamanho() - 1));
        System.out.println();

        //Lista já com alguns elementos//

        System.out.println("2. Inserção em lista não vazia");
        ListaSequencialCapacidadeVariavel<String> lista2 = new ListaSequencialCapacidadeVariavel<>(5);
        lista2.inserir("A", 0);
        lista2.inserir("B", 1);
        System.out.println("   Estado inicial: " + lista2.imprimir());

        String[] lote2 = {"C", "D", "E", "F"};
        lista2.inserirEmLote(lote2);

        System.out.println("   Após inserir lote de 4 elementos:");
        System.out.println("   Conteúdo: " + lista2.imprimir());
        System.out.println("   Tamanho: " + lista2.tamanho());
        System.out.println();

        //Array nulo//

        System.out.println("2.1 Array nulo (não deve alterar lista)");
        String[] loteNulo = null;
        lista2.inserirEmLote(loteNulo);
        System.out.println("   Lista permanece inalterada: " + lista2.imprimir());
        System.out.println();

        //Array vazio//

        System.out.println("3. Array vazio (não deve alterar lista)");
        ListaSequencialCapacidadeVariavel<Double> lista3 = new ListaSequencialCapacidadeVariavel<>();
        lista3.inserir(1.5, 0);
        System.out.println("   Estado inicial: " + lista3.imprimir());

        Double[] loteVazio = {};
        lista3.inserirEmLote(loteVazio);
        System.out.println("   Após inserir array vazio: " + lista3.imprimir());
        System.out.println();

    }

}