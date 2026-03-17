package estruturas.lineares.estaticas.lista;

import estruturas.lineares.IListaLinear;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaSequencial<T> implements IListaLinear<T>, Iterable<T> {

    /////////////
    //Atributos//
    /////////////

    private int tamanho;
    private T[] elementos;

    //////////////
    //Construtor//
    //////////////

    @SuppressWarnings("unchecked")
    public ListaSequencial(int capacidade) {
        if (capacidade < 0) {
            throw new IllegalArgumentException("A capacidade do vetor não pode ser negativa");
        }
        this.tamanho = 0;
        this.elementos = (T[]) new Object[capacidade];
    }

    ////////////////////////
    //Operações Auxiliares//
    ////////////////////////

    //Verifica se a posicao/indice passado como parâmetro está fora dos limites do vetor (IndexOutOfBounds)
    private void verificarPosicao(int posicao, int minimo, int maximo) {
        if (posicao < minimo || posicao > maximo) {
            throw new IndexOutOfBoundsException(
                    String.format("Índice: %d, Tamanho: %d", posicao, this.tamanho)
            );
        }
    }

    //Verifica a capacidade do vetor
    private void verificarCapacidade() {
        if (this.tamanho == this.elementos.length) {
            throw new IllegalStateException("Capacidade máxima atingida.");
        }
    }

    ////////////////////////////////////////////
    //Operações de Consulta (Query Operations)//
    ////////////////////////////////////////////

    public int capacidade() {
        return this.elementos.length;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public int posicao(T elemento) {
        for (int indice = 0; indice < this.tamanho; indice++) {
            if (Objects.equals(elemento, this.elementos[indice])) {
                return indice;
            }
        }
        return -1;
    }

    @Override
    public boolean contem(T elemento) {
        return this.posicao(elemento) != -1;
    }

    @Override
    public String imprimir() {
        return Arrays.toString(Arrays.copyOf(this.elementos, this.tamanho));
    }

    @Override
    public T obter(int posicao) {
        this.verificarPosicao(posicao, 0, this.tamanho - 1);
        return (T) this.elementos[posicao];
    }

    ////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations)//
    ////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    @Override
    public void inserir(T elemento, int posicao) {
        this.verificarPosicao(posicao, 0, this.elementos.length - 1);
        this.verificarCapacidade();
        if (elemento == null) {
            System.out.println("Não é possível adicionar elementos vazios a lista.");
            return;
        }
        if (this.elementos[posicao] != null) {
            Object[] arrayFinal = Arrays.copyOfRange(this.elementos, posicao, this.elementos.length - 1);
            Object[] arrayInicio = new Object[posicao + 1];
            System.arraycopy(this.elementos, 0, arrayInicio, 0, posicao);
            arrayInicio[arrayInicio.length - 1] = elemento;
            this.elementos = (T[]) new Object[this.capacidade()];
            System.arraycopy(arrayInicio, 0, this.elementos, 0, arrayInicio.length);
            System.arraycopy(arrayFinal, 0, this.elementos, arrayInicio.length, arrayFinal.length);
        } else {
            this.elementos[posicao] = elemento;
        }

        this.tamanho++;
    }

    @Override
    public void atualizar(int posicao, T elemento) {
        this.verificarPosicao(posicao, 0, this.elementos.length - 1);
        this.elementos[posicao] = elemento;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remover(int posicao) {

        T elementoRemovido = this.obter(posicao);

        if (elementoRemovido == null) {
            System.out.printf("Não há elemento na posição %d.\n", posicao);
            /*throw new IllegalStateException(String.format("Não há elemento na posição %d.", posicao));*/
        }
        Object[] arrayFinal = Arrays.copyOfRange(this.elementos, posicao + 1, this.elementos.length);
        Object[] arrayInicio = Arrays.copyOfRange(this.elementos, 0, posicao);
        this.elementos = (T[]) new Object[this.capacidade()];
        this.tamanho--;
        System.arraycopy(arrayInicio,0, this.elementos, 0, arrayInicio.length);
        System.arraycopy(arrayFinal,0, this.elementos, arrayInicio.length, arrayFinal.length);

        return elementoRemovido;
    }

    @Override
    public void limpar() {
        Arrays.fill(this.elementos, null);
        this.tamanho = 0;
    }

    ////////////////////////////////////////////////////////////////
    //Operações Derivadas de Mutação (Derived Mutation Operations)//
    ////////////////////////////////////////////////////////////////

    public void inserirInicio(T elemento) {
        this.inserir(elemento, 0);
    }

    public void removerElemento(T elemento) {
        if (elemento == null) {
            System.out.println("Não é possível inserir um elemento nulo na lista.");
            return;
        }
        if (!contem(elemento)) {
            System.out.printf("Não existe o elemento '%s' na lista.\n", elemento);
            return;
            /*throw new IllegalStateException(String.format("Não existe o elemento '%s' na lista.", elemento));*/
        }

        int posicao = this.posicao(elemento);
        this.remover(posicao);
    }

    public void removerInicio() {
        this.remover(0);
    }

    public void removerFim() {
        this.remover(tamanho - 1);
    }

    ////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations)//
    ////////////////////////////////////////////////

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int posicao = 0;

            @Override
            public boolean hasNext() {
                return posicao < tamanho;
            }

            @Override
            public T next() throws NoSuchElementException  {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elementos[posicao++];
            }
        };
    }

}