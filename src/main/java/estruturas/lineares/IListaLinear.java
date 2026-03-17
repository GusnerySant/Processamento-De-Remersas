package estruturas.lineares;

import java.util.Iterator;

public interface IListaLinear<T> {

    ////////////////////////////////////////////
    //Operações de Consulta (Query Operations)//
    ////////////////////////////////////////////

    //Retorna o número de elementos na lista
    public int tamanho();

    //Verifica se a lista está vazia
    public boolean estaVazia();

    //Retorna a posição de um determinado elemento na lista
    //Obs.: posição da primeira ocorrência do elemento na lista
    public int posicao(T elemento);

    //Verifica se a lista contém o elemento passado como parâmetro
    public boolean contem(T elemento);

    //Retorna um texto que representa a lista.
    public String imprimir();

    //Obtem o elemento que está armazenado na posição passado por parâmetro
    //Analogia: R (Read) do CRUD
    public T obter(int posicao);

    ////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations)//
    ////////////////////////////////////////////////////////////

    //Insere um elemento na posição passada por parâmetro
    //Analogia: C (Create) do CRUD
    public void inserir(T elemento, int posicao);

    //Atualiza o elemento que está armazenado na posição passada por parâmetro
    //Analogia: U (Update) do CRUD
    public void atualizar(int posicao, T elemento);

    //Remove e retorna o elemento da posição passada por parâmetro
    //Analogia: D (Delete) do CRUD
    public T remover(int posicao);

    //Remove todos os elementos da lista
    public void limpar();

    ////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations)//
    ////////////////////////////////////////////////

    //Retorna um iterador que possibilitará percorrer cada elemento da coleção na lista
    public Iterator<T> iterator();

}