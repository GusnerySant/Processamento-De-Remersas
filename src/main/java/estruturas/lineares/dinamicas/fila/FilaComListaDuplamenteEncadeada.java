package estruturas.lineares.dinamicas.fila;

import java.util.Iterator;

import estruturas.lineares.IFila;
import estruturas.lineares.dinamicas.lista.IListaDuplamenteEncadeada;
import estruturas.lineares.dinamicas.lista.ListaDuplamenteEncadeada;

public class FilaComListaDuplamenteEncadeada<T> implements IFila<T> {

    /////////////
    //Atributos//
    /////////////

    private IListaDuplamenteEncadeada<T> lista;

    //////////////
    //Construtor//
    //////////////

    public FilaComListaDuplamenteEncadeada() {
        this.lista = new ListaDuplamenteEncadeada<>();
    }

    ////////////////////////////////////////////////////
    //Operações de Consulta (Query Operations) - IFila//
    ////////////////////////////////////////////////////

    @Override
    public int tamanho() {
        return this.lista.tamanho();
    }

    @Override
    public boolean estaVazia() {
        return this.lista.estaVazia();
    }

    @Override
    public boolean contem(T elemento) {
        return this.lista.contem(elemento);
    }

    @Override
    public String imprimir() {
        return this.lista.imprimir();
    }

    @Override
    public T obterFrente() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        return this.lista.obterPrimeiroNo().obterElemento();
    }

    @Override
    public int distancia(T elemento) {
        if (!this.contem(elemento)) {
            return -1;
        }

        int distancia = 0;
        Iterator<T> iterator = this.lista.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(elemento)) {
                return distancia;
            }
            distancia++;
        }
        return -1;
    }

    ////////////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations) - IFila//
    ////////////////////////////////////////////////////////////////////

    @Override
    public void enfileirar(T elemento) {
        this.lista.adicionarFim(elemento);
    }

    @Override
    public T desenfileirar() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        T frente = this.obterFrente();
        lista.removerInicio();
        return frente;
    }

    @Override
    public void limpar() {
        this.lista.limpar();
    }

    ////////////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations) - IFila//
    ////////////////////////////////////////////////////////

    @Override
    public Iterator<T> iterator() {
        return this.lista.iterator();
    }

}