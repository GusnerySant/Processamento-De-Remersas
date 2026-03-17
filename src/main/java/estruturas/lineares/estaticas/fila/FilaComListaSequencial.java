package estruturas.lineares.estaticas.fila;

import java.util.Iterator;
import java.util.Objects;

import estruturas.lineares.IFila;
import estruturas.lineares.IListaLinear;
import estruturas.lineares.estaticas.lista.ListaSequencialCapacidadeVariavel;

public class FilaComListaSequencial<T> implements IFila<T> {

    /////////////
    //Atributos//
    /////////////

    private final IListaLinear<T> elementos; //Lista de elementos

    //////////////
    //Construtor//
    //////////////

    public FilaComListaSequencial() {
        this.elementos = new ListaSequencialCapacidadeVariavel<>();
    }

    public FilaComListaSequencial(int capacidade) {
        this.elementos = new ListaSequencialCapacidadeVariavel<>(capacidade);
    }

    ////////////////////////////////////////////////////
    //Operações de Consulta (Query Operations) - IFila//
    ////////////////////////////////////////////////////

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
    public T obterFrente() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        return this.elementos.obter(0);
    }

    @Override
    public int distancia(T elemento) {
        // Percorre o vetor a partir da frente (índice 0) até o fim
        for (int i = 0; i < this.elementos.tamanho(); i++) {
            T elementoAtual = this.elementos.obter(i);
            // Verifica se encontrou o elemento
            if (Objects.equals(elemento, elementoAtual)) {
                // Retorna a posição relativa à frente
                return i;
            }
        }
        // Elemento não encontrado na fila
        return -1;
    }

    ////////////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations) - IFila//
    ////////////////////////////////////////////////////////////////////

    @Override
    public void enfileirar(T elemento) {
        this.elementos.inserir(elemento,this.elementos.tamanho()); // Adiciona no fim do vetor
    }

    @Override
    public T desenfileirar() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        return this.elementos.remover(0);
    }

    @Override
    public void limpar() {
        this.elementos.limpar();
    }

    ////////////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations) - IFila//
    ///////////////////////////////////////////////////////

    @Override
    public Iterator<T> iterator() {
        return this.elementos.iterator();
    }

}