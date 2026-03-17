package estruturas.lineares.dinamicas.lista;

public interface INoListaDuplamenteEncadeada<T> {

    //Retorna o elemento armazenado no nó.
    public T obterElemento();

    //Define o elemento a ser armazenado no nó
    public void definirElemento(T elemento);

    //Retorna o próximo nó da lista
    public INoListaDuplamenteEncadeada<T> obterProximoNo();

    //Define o próximo nó da lista
    public void definirProximoNo(INoListaDuplamenteEncadeada<T> proximoNo);

    //Retorna o nó anterior da lista
    public INoListaDuplamenteEncadeada<T> obterNoAnterior();

    //Define o nó anterior da lista
    public void definirNoAnterior(INoListaDuplamenteEncadeada<T> noAnterior);


}