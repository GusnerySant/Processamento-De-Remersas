package estruturas.lineares.dinamicas.lista;


public class NoListaSimplesmenteEncadeada<T> implements INoListaSimplesmenteEncadeada<T> {

    /////////////
    //Atributos//
    /////////////

    private T elemento;
    private INoListaSimplesmenteEncadeada<T> proximoNo;

    ////////////////
    //Construtores//
    ////////////////

    public NoListaSimplesmenteEncadeada(T elemento) {
        this.elemento = elemento;
        this.proximoNo = null;
    }

    public NoListaSimplesmenteEncadeada(T elemento, INoListaSimplesmenteEncadeada<T> proximoNo) {
        this.elemento = elemento;
        this.proximoNo = proximoNo;
    }

    ///////////
    //Métodos//
    ///////////

    @Override
    public T obterElemento() {
        return this.elemento;
    }

    @Override
    public void definirElemento(T elemento) {
        this.elemento = elemento;
    }

    @Override
    public INoListaSimplesmenteEncadeada<T> obterProximoNo() {
        return this.proximoNo;
    }

    @Override
    public void definirProximoNo(INoListaSimplesmenteEncadeada<T> proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
        return "Elemento: " + this.obterElemento();
    }

}