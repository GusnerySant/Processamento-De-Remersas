package estruturas.lineares.dinamicas.lista;

import estruturas.lineares.IListaLinear;

public interface IListaDuplamenteEncadeada<T> extends IListaLinear<T> {

    ////////////////////////////////////////////
    //Operações de Consulta (Query Operations)//
    ////////////////////////////////////////////

    //Retorna a referencia do primeiro nó da lista
    public INoListaDuplamenteEncadeada<T> obterPrimeiroNo();

    //Retorna a referencia do último nó da lista
    public INoListaDuplamenteEncadeada<T> obterUltimoNo();

    //Obtem um nó que está em uma determinada posição da lista
    public INoListaDuplamenteEncadeada<T> obterNoDuplamenteEncadeado(int posicao);

    ////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations)//
    ////////////////////////////////////////////////////////////

    //Adiciona um nó no início da lista
    public void adicionarInicio(T elemento);

    //Adiciona um nó no fim da lista
    public void adicionarFim(T elemento);

    //Remove o nó do início da lista
    public void removerInicio();

    //Remove o nó do fim da lista
    public void removerFim();

    ////////////////////////////////////////////////////////////////
    //Operações Derivadas de Mutação (Derived Mutation Operations)//
    ////////////////////////////////////////////////////////////////

    //Remove o nó que contém o dado passado por parâmetro
    //Obs.: Remove o nó que contém a primeira ocorrência do elemento na lista
    public void remover(T elemento);

}