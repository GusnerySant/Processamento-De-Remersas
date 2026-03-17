package estruturas.lineares;

import java.util.Iterator;

public interface IPilha<T> {

    ////////////////////////////////////////////
    //Operações de Consulta (Query Operations)//
    ////////////////////////////////////////////

    //Retorna a quantidade de elementos na pilha
    public int tamanho();

    //Verifica se a pilha esta vazia ou não
    public boolean estaVazia();

    //Verifica se a pilha contém o elemento passado como parâmetro
    public boolean contem(T elemento);

    //Retorna um texto que representa a pilha.
    public String imprimir();

    //Obtem o elemento do topo da pilha sem remover - peek
    //Analogia: R (Read) do CRUD
    public T obterTopo();

    //Retorna a distancia de um elemento em relacao ao topo da pilha
    //O vizinho mais proximo possui distancia 1 do topo
    //Se o elemento for o proprio topo, entao retorna-se 0
    //Caso o elemento nao exista, retorna-se -1
    //Obs.: distancia da primeira ocorrência do elemento na pilha
    public int distancia(T elemento);

    ////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations)//
    ////////////////////////////////////////////////////////////

    //Empilha um elemento no topo da pilha - push
    public void empilhar(T elemento);

    //Desempilha e retorna o elemento do topo da pilha - pop
    public T desempilhar();

    //Remove todos os dados da pilha
    public void limpar();

    ////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations)//
    ////////////////////////////////////////////////

    //Retorna um iterador que possibilitará percorrer cada dado da pilha
    public Iterator<T> iterator();


}