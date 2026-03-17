package estruturas.lineares;

import java.util.Iterator;

public interface IFila<T> {

    ////////////////////////////////////////////
    //Operações de Consulta (Query Operations)//
    ////////////////////////////////////////////

    //Retorna a quantidade de elementos na fila
    public int tamanho();

    //Verifica se a fila esta vazia ou não
    public boolean estaVazia();

    //Verifica se a fila contém o elemento passado como parâmetro
    public boolean contem(T elemento);

    //Retorna um texto que representa a fila
    public String imprimir();

    //Retorna o elemento da frente da fila sem remover - peek
    //Analogia: R (Read) do CRUD
    public T obterFrente();

    //Retorna a distancia de um elemento em relacao a frente da fila
    //O vizinho mais proximo possui distancia 1 da frente da fila
    //Se o elemento for o elemento da frente da fila, entao retorna-se 0
    //Caso o elemento nao exista na fila, retorna-se -1
    //Obs.: distancia da primeira ocorrência do elemento na fila
    public int distancia(T elemento);

    ////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations)//
    ////////////////////////////////////////////////////////////

    //Enfilera um elemento no final da fila - enqueue
    public void enfileirar(T elemento);

    //Desenfilera e retorna o elemento na frente da fila - dequeue
    public T desenfileirar();

    //Remove todos os elementos da fila
    public void limpar();

    ////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations)//
    ////////////////////////////////////////////////

    //Retorna um iterador que possibilitará percorrer cada elemento da fila
    public Iterator<T> iterator();

}