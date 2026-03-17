package estruturas.lineares.dinamicas.lista;

public class AppListaSimplesmenteEncadeada {

    public static void main(String[] args) {

        //Exemplo de Uso da Lista Simplesmente Encadeada
        IListaSimplesmenteEncadeada<String> lista = new ListaSimplesmenteEncadeada<>();
        lista.adicionarInicio("A");
        lista.adicionarInicio("B");
        lista.adicionarInicio("C");
        lista.adicionarFim("D");
        System.out.println(lista.imprimir());
        System.out.println(lista.posicao("A"));
        System.out.println(lista.posicao("B"));
        System.out.println(lista.posicao("D"));
        System.out.println(lista.posicao("E"));

        System.out.println(lista.obter(3));
        System.out.println(lista.obter(0));


        lista.atualizar(0,"Z");
        System.out.println(lista.imprimir());


        lista.remover(2);
        System.out.println(lista.imprimir());

        lista.remover("B");
        System.out.println(lista.imprimir());


    }


}