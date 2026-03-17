package estruturas.lineares.estaticas.pilha;

import java.util.Iterator;
import java.util.Objects;

import estruturas.lineares.IListaLinear;
import estruturas.lineares.IPilha;
import estruturas.lineares.estaticas.lista.ListaSequencial;

public class PilhaComListaSequencial<T> implements IPilha<T> {

    /////////////
    //Atributos//
    /////////////

    private final IListaLinear<T> elementos; //Lista de elementos

    //////////////
    //Construtor//
    //////////////

    public PilhaComListaSequencial() {
        this.elementos = new ListaSequencial<>(10);
    }

    public PilhaComListaSequencial(int capacidade) {
        this.elementos = new ListaSequencial<>(capacidade);
    }

    /////////////////////////////////////////////////////
    //Operações de Consulta (Query Operations) - IPilha//
    /////////////////////////////////////////////////////

    @Override
    public int tamanho() {
        return this.elementos.tamanho();
    }

    @Override
    public boolean estaVazia() {
        return this.elementos.estaVazia();
    }


    @Override
    public boolean contem(T elemento) {
        return this.elementos.contem(elemento);
    }

    @Override
    public String imprimir() {
        return this.elementos.imprimir();
    }

    @Override
    public T obterTopo() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return this.elementos.obter(elementos.tamanho() - 1);
    }

    @Override
    public int distancia(T elemento) {
        //Percorre do topo (último elemento) para a base (primeiro elemento)
        for (int i = this.elementos.tamanho() - 1, distancia = 0; i >= 0; i--, distancia++) {
            if (Objects.equals(this.elementos.obter(i), elemento)) {
                return distancia;
            }
        }
        return -1; // Elemento não encontrado
    }

    /////////////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations) - IPilha//
    /////////////////////////////////////////////////////////////////////

    @Override
    public void empilhar(T elemento) {
        this.elementos.inserir(elemento,this.elementos.tamanho()); // Adiciona no fim do vetor (topo da pilha)
    }

    @Override
    public T desempilhar() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return this.elementos.remover(this.elementos.tamanho() - 1);
    }

    @Override
    public void limpar() {
        this.elementos.limpar();
    }

    /////////////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations) - IPilha//
    /////////////////////////////////////////////////////////

    @Override
    public Iterator<T> iterator() {
        return this.elementos.iterator();
    }

}