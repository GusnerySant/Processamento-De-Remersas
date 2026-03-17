package estruturas.lineares.dinamicas.pilha;

import java.util.Iterator;
import java.util.Objects;

import estruturas.lineares.IPilha;
import estruturas.lineares.dinamicas.lista.IListaSimplesmenteEncadeada;
import estruturas.lineares.dinamicas.lista.ListaSimplesmenteEncadeada;

public class PilhaComListaSimplesmenteEncadeada<T> implements IPilha<T> {

    /////////////
    //Atributos//
    /////////////

    private final IListaSimplesmenteEncadeada<T> lista;

    //////////////
    //Construtor//
    //////////////

    public PilhaComListaSimplesmenteEncadeada() {
        this.lista = new ListaSimplesmenteEncadeada<>();
    }

    /////////////////////////////////////////////////////
    //Operações de Consulta (Query Operations) - IPilha//
    /////////////////////////////////////////////////////

    @Override
    public int tamanho() {
        return this.lista.tamanho();
    }

    @Override
    public boolean estaVazia() {
        return  this.lista.estaVazia();
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
    public T obterTopo() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return this.lista.obterPrimeiroNo().obterElemento();
    }

    @Override
    public int distancia(T elemento) {
        int distancia = 0;
        var noAtual = this.lista.obterPrimeiroNo();

        while (noAtual != null) {
            if (Objects.equals(noAtual.obterElemento(), elemento)) {
                return distancia;
            }
            distancia++;
            noAtual = noAtual.obterProximoNo();
        }
        return -1;
    }

    /////////////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations) - IPilha//
    /////////////////////////////////////////////////////////////////////

    @Override
    public void empilhar(T elemento) {
        this.lista.adicionarInicio(elemento);
    }

    @Override
    public T desempilhar() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        T topo = this.lista.obterPrimeiroNo().obterElemento();
        lista.removerInicio();
        return topo;
    }

    @Override
    public void limpar() {
        this.lista.limpar();
    }

    /////////////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations) - IPilha//
    /////////////////////////////////////////////////////////

    @Override
    public Iterator<T> iterator() {
        return this.lista.iterator();
    }

}