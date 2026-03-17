package estruturas.lineares.dinamicas.lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDuplamenteEncadeada<T> implements IListaDuplamenteEncadeada<T>,Iterable<T> {

    /////////////
    //Atributos//
    /////////////

    private INoListaDuplamenteEncadeada<T> noCabeca; //Também chamado de nó sentinela
    private int quantidadeNos;

    //////////////
    //Construtor//
    //////////////

    public ListaDuplamenteEncadeada() {
        this.noCabeca = new NoListaDuplamenteEncadeada<T>(null);
        this.noCabeca.definirProximoNo(null);
        this.noCabeca.definirNoAnterior(null);
        this.quantidadeNos = 0;
    }

    ////////////////////////////////////////////////////////////////////////
    //Operações de Consulta (Query Operations) - IListaDuplamenteEncadeada//
    ////////////////////////////////////////////////////////////////////////

    @Override
    public INoListaDuplamenteEncadeada<T> obterPrimeiroNo() {
        return this.noCabeca.obterProximoNo();
    }

    @Override
    public INoListaDuplamenteEncadeada<T> obterUltimoNo() {
        return this.noCabeca.obterNoAnterior();
    }

    @Override
    public INoListaDuplamenteEncadeada<T> obterNoDuplamenteEncadeado(int posicao) {
        if (posicao < 0 || posicao >= this.quantidadeNos) {
            throw new IndexOutOfBoundsException("Posição fora dos limites: " + posicao);
        }
        //Verifica se vai iniciar a pesquisar o nó a partir do início ou do fim da lista - Otimização
        if (posicao < this.quantidadeNos / 2) {
            INoListaDuplamenteEncadeada<T> noAtual = this.obterPrimeiroNo();
            for (int i = 0; i < posicao; i++) {
                noAtual = noAtual.obterProximoNo();
            }
            return noAtual;
        } else {
            INoListaDuplamenteEncadeada<T> noAtual = this.obterUltimoNo();
            for (int i = this.quantidadeNos - 1; i > posicao; i--) {
                noAtual = noAtual.obterNoAnterior();
            }
            return noAtual;
        }
    }

    ///////////////////////////////////////////////////////////
    //Operações de Consulta (Query Operations) - IListaLinear//
    ///////////////////////////////////////////////////////////

    @Override
    public T obter(int posicao) {
        INoListaDuplamenteEncadeada<T> no = this.obterNoDuplamenteEncadeado(posicao);
        return no.obterElemento();
    }

    @Override
    public int tamanho() {
        return this.quantidadeNos;
    }

    @Override
    public boolean estaVazia() {
        return this.quantidadeNos == 0;
    }

    @Override
    public int posicao(T elemento) {
        INoListaDuplamenteEncadeada<T> noAtual = this.obterPrimeiroNo();
        int posicao = 0;
        while (noAtual != null) {
            if (noAtual.obterElemento().equals(elemento)) {
                return posicao;
            }
            noAtual = noAtual.obterProximoNo();
            posicao++;
        }
        return -1; // Retorna -1 se o elemento não for encontrado na lista
    }

    @Override
    public boolean contem(T elemento) {
        INoListaDuplamenteEncadeada<T> noAtual = this.obterPrimeiroNo();
        while (noAtual != null) {
            if (noAtual.obterElemento().equals(elemento)) {
                return true;
            }
            noAtual = noAtual.obterProximoNo();
        }
        return false;
    }

    @Override
    public String imprimir() {
        StringBuilder stringBuilder = new StringBuilder();
        INoListaDuplamenteEncadeada<T> noAtual = this.obterPrimeiroNo();
        while (noAtual != null) {
            stringBuilder.append(noAtual.obterElemento().toString());
            noAtual = noAtual.obterProximoNo();
            if (noAtual != null) {
                stringBuilder.append(" -> ");
            }
        }
        return stringBuilder.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations) - IListaDuplamenteEncadeada//
    ////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void adicionarInicio(T elemento) {
        INoListaDuplamenteEncadeada<T> novoNo = new NoListaDuplamenteEncadeada<>(elemento);
        if (this.estaVazia()) {
            novoNo.definirProximoNo(null);
            novoNo.definirNoAnterior(null);
            this.noCabeca.definirProximoNo(novoNo);
            this.noCabeca.definirNoAnterior(novoNo);
        } else {
            INoListaDuplamenteEncadeada<T> primeiroNo = this.obterPrimeiroNo();
            novoNo.definirProximoNo(primeiroNo);
            novoNo.definirNoAnterior(null);
            primeiroNo.definirNoAnterior(novoNo);
            this.noCabeca.definirProximoNo(novoNo);
        }
        this.quantidadeNos++;
    }

    @Override
    public void adicionarFim(T elemento) {
        INoListaDuplamenteEncadeada<T> novoNo = new NoListaDuplamenteEncadeada<>(elemento);
        if (this.estaVazia()) {
            this.noCabeca.definirProximoNo(novoNo);
            this.noCabeca.definirNoAnterior(novoNo);
            novoNo.definirNoAnterior(null);
            novoNo.definirProximoNo(null);
        } else {
            INoListaDuplamenteEncadeada<T> ultimoNo = this.obterUltimoNo();
            novoNo.definirNoAnterior(ultimoNo);
            novoNo.definirProximoNo(null);
            ultimoNo.definirProximoNo(novoNo);
            this.noCabeca.definirNoAnterior(novoNo);
        }
        this.quantidadeNos++;
    }

    @Override
    public void removerInicio() {
        if (this.estaVazia()) {
            throw new NoSuchElementException("Lista vazia");
        }
        INoListaDuplamenteEncadeada<T> primeiroNo = this.obterPrimeiroNo();
        INoListaDuplamenteEncadeada<T> segundoNo = primeiroNo.obterProximoNo();
        this.noCabeca.definirProximoNo(segundoNo);
        if (segundoNo != null) {
            segundoNo.definirNoAnterior(null);
        } else {
            this.noCabeca.definirNoAnterior(null);
        }
        this.quantidadeNos--;
    }

    @Override
    public void removerFim() {
        if (this.estaVazia()) {
            throw new NoSuchElementException("Lista vazia");
        }
        INoListaDuplamenteEncadeada<T> ultimoNo = this.obterUltimoNo();
        INoListaDuplamenteEncadeada<T> penultimoNo = ultimoNo.obterNoAnterior();
        this.noCabeca.definirNoAnterior(penultimoNo);
        if (penultimoNo != null) {
            penultimoNo.definirProximoNo(null);
        } else {
            this.noCabeca.definirProximoNo(null);
        }
        this.quantidadeNos--;
    }

    ///////////////////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations) - IListaLinear//
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void inserir(T elemento, int posicao) {
        if (posicao < 0 || posicao > this.quantidadeNos) {
            throw new IndexOutOfBoundsException("Posição fora dos limites: " + posicao);
        }
        if (posicao == 0) {
            this.adicionarInicio(elemento);
        }
        else if (posicao == this.quantidadeNos) {
            this.adicionarFim(elemento);
        }
        else {
            INoListaDuplamenteEncadeada<T> noAtual = this.obterNoDuplamenteEncadeado(posicao);
            INoListaDuplamenteEncadeada<T> noAnterior = noAtual.obterNoAnterior();
            NoListaDuplamenteEncadeada<T> novoNo = new NoListaDuplamenteEncadeada<>(elemento);
            novoNo.definirProximoNo(noAtual);
            novoNo.definirNoAnterior(noAnterior);
            noAnterior.definirProximoNo(novoNo);
            noAtual.definirNoAnterior(novoNo);
            this.quantidadeNos++;
        }
    }

    @Override
    public void atualizar(int posicao, T elemento) {
        INoListaDuplamenteEncadeada<T> no = this.obterNoDuplamenteEncadeado(posicao);
        no.definirElemento(elemento);
    }

    @Override
    public T remover(int posicao) {
        if (posicao < 0 || posicao > this.quantidadeNos) {
            throw new IndexOutOfBoundsException("Posição fora dos limites: " + posicao);
        }
        T elementoRemovido;
        if (posicao == 0) {
            elementoRemovido = this.obter(0);
            this.removerInicio();
        }
        else if (posicao == this.quantidadeNos - 1) {
            elementoRemovido = this.obter(this.quantidadeNos - 1);
            this.removerFim();
        }
        else {
            INoListaDuplamenteEncadeada<T> noAtual = this.obterNoDuplamenteEncadeado(posicao);
            elementoRemovido = noAtual.obterElemento();
            INoListaDuplamenteEncadeada<T> noAnterior = noAtual.obterNoAnterior();
            INoListaDuplamenteEncadeada<T> proximoNo = noAtual.obterProximoNo();
            noAnterior.definirProximoNo(proximoNo);
            proximoNo.definirNoAnterior(noAnterior);
            this.quantidadeNos--;
        }
        return elementoRemovido;
    }

    @Override
    public void limpar() {
        this.noCabeca.definirProximoNo(null);
        this.noCabeca.definirNoAnterior(null);
        this.quantidadeNos = 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    //Operações Derivadas de Mutação (Derived Mutation Operations) - IListaDuplamenteEncadeada//
    ////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void remover(T elemento) {
        int posicao = this.posicao(elemento);
        if (posicao != -1) {
            this.remover(posicao);
        }
    }

    ///////////////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations) - Iterable//
    ///////////////////////////////////////////////////////////

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            INoListaDuplamenteEncadeada<T> noAtual = obterPrimeiroNo();

            @Override
            public boolean hasNext() {
                return noAtual != null;
            }

            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    T dado = (T) noAtual.obterElemento();
                    noAtual = noAtual.obterProximoNo();
                    return dado;
                }
            }
        };
    }

}