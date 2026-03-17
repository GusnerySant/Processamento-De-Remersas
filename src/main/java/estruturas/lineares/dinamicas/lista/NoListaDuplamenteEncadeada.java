package estruturas.lineares.dinamicas.lista;

public class NoListaDuplamenteEncadeada<T> implements INoListaDuplamenteEncadeada<T> {

    private T elemento;
    private INoListaDuplamenteEncadeada<T> proximoNo;
    private INoListaDuplamenteEncadeada<T> noAnterior;

    public NoListaDuplamenteEncadeada(T elemento) {
        this.definirElemento(elemento);
        this.definirProximoNo(null);
        this.definirNoAnterior(null);
    }

    public NoListaDuplamenteEncadeada(T elemento, INoListaDuplamenteEncadeada<T> proximoNo, INoListaDuplamenteEncadeada<T> noAnterior) {
        this.definirElemento(elemento);
        this.definirProximoNo(proximoNo);
        this.definirNoAnterior(noAnterior);
    }

    @Override
    public T obterElemento() {
        return this.elemento;
    }

    @Override
    public void definirElemento(T elemento) {
        this.elemento = elemento;
    }

    @Override
    public INoListaDuplamenteEncadeada<T> obterProximoNo() {
        return this.proximoNo;
    }

    @Override
    public void definirProximoNo(INoListaDuplamenteEncadeada<T> proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public INoListaDuplamenteEncadeada<T> obterNoAnterior() {
        return this.noAnterior;
    }

    @Override
    public void definirNoAnterior(INoListaDuplamenteEncadeada<T> noAnterior) {
        this.noAnterior = noAnterior;
    }

}