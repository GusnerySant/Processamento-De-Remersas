package estruturas.lineares.dinamicas.lista;

public interface INoListaSimplesmenteEncadeada<T> {

    //Retorna o elemento armazenado no nó.
    public T obterElemento();

    //Define o elemento a ser armazenado no nó
    public void definirElemento(T elemento);

    //Retorna o próximo nó da lista
    public INoListaSimplesmenteEncadeada<T> obterProximoNo();

    //Define o próximo nó da lista
    public void definirProximoNo(INoListaSimplesmenteEncadeada<T> proximoNo);

}