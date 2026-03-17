package estruturas.lineares.dinamicas.lista;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaSimplesmenteEncadeada<T> implements IListaSimplesmenteEncadeada<T>,Iterable<T> {

    /////////////
    //Atributos//
    /////////////

    private INoListaSimplesmenteEncadeada<T> primeirNo;
    private INoListaSimplesmenteEncadeada<T> ultimoNo;
    private int quantidadeNos;

    //////////////
    //Construtor//
    //////////////

    public ListaSimplesmenteEncadeada(){
        this.limpar();
    }

    ////////////////////////////////////////////
    //Operações de Consulta (Query Operations)//
    ////////////////////////////////////////////

    @Override
    public INoListaSimplesmenteEncadeada<T> obterPrimeiroNo() {
        return this.primeirNo;
    }

    @Override
    public INoListaSimplesmenteEncadeada<T> obterUltimoNo() {
        return this.ultimoNo;
    }

    @Override
    public int tamanho() {
        return this.quantidadeNos;
    }

    @Override
    public boolean estaVazia() {
        if (this.quantidadeNos == 0){
            return true;
        }
        return false;
    }

    @Override
    public int posicao(T elemento) {
        INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
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
        INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
        while (noAtual != null) {
            if (Objects.equals(noAtual.obterElemento(), elemento)) {
                return true;
            }
            noAtual = noAtual.obterProximoNo();
        }
        return false;
    }

    @Override
    public String imprimir() {
        StringBuilder stringBuilder = new StringBuilder();
        INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
        while (noAtual != null) {
            stringBuilder.append(noAtual.obterElemento().toString());
            noAtual = noAtual.obterProximoNo();
            if (noAtual != null) {
                stringBuilder.append(" -> ");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public T obter(int posicao) {
        if (posicao < 0 || posicao >= this.quantidadeNos) {
            throw new IndexOutOfBoundsException();
        }
        INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.obterProximoNo();
        }
        return noAtual.obterElemento();
    }

    ////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations)//
    ////////////////////////////////////////////////////////////

    @Override
    public void adicionarInicio(T elemento) {
        INoListaSimplesmenteEncadeada<T> novoNo = new NoListaSimplesmenteEncadeada<>(elemento);
        if (this.primeirNo == null){
            this.primeirNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            novoNo.definirProximoNo(this.primeirNo);
            this.primeirNo = novoNo;
        }
        this.quantidadeNos++;
    }

    @Override
    public void adicionarFim(T elemento) {
        INoListaSimplesmenteEncadeada<T> novoNo = new NoListaSimplesmenteEncadeada<>(elemento);
        if (this.primeirNo == null){
            this.primeirNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.ultimoNo.definirProximoNo(novoNo);
            this.ultimoNo = novoNo;
        }
        this.quantidadeNos++;
    }

    @Override
    public void removerInicio() {
        if (!this.estaVazia()){
            if (this.quantidadeNos == 1) {
                this.limpar();
            }
            else {
                this.primeirNo = this.primeirNo.obterProximoNo();
                this.quantidadeNos--;
            }
        }
    }

    @Override
    public void removerFim() {
        if (!this.estaVazia()) {
            INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
            if (this.quantidadeNos == 1) {
                this.limpar();
            } else {
                while (noAtual.obterProximoNo() != this.ultimoNo) {
                    noAtual = noAtual.obterProximoNo();
                }
                noAtual.definirProximoNo(null);
                this.ultimoNo = noAtual;
                this.quantidadeNos--;
            }
        }
    }

    @Override
    public void inserir(T elemento, int posicao) {
        INoListaSimplesmenteEncadeada<T> novoNo = new NoListaSimplesmenteEncadeada<T>(elemento);
        INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
        if (posicao < 0 || posicao > quantidadeNos) {
            throw new IndexOutOfBoundsException();
        }
        else if (posicao == 0){
            this.adicionarInicio(elemento);
        }
        else if (posicao == quantidadeNos) {
            this.adicionarFim(elemento);
        }
        else{
            int i = 1;
            while (i < quantidadeNos) {
                if (i == posicao) {
                    novoNo.definirProximoNo(noAtual.obterProximoNo());
                    noAtual.definirProximoNo(novoNo);
                    quantidadeNos++;
                    break;
                }
                noAtual = noAtual.obterProximoNo();
                i++;
            }
        }
    }

    @Override
    public void atualizar(int posicao, T elemento) {
        if (posicao < 0 || posicao >= quantidadeNos) {
            throw new IndexOutOfBoundsException();
        }
        INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.obterProximoNo();
        }
        noAtual.definirElemento(elemento); // Assumindo que NoListaSimplesmenteEncadeada tem este método
    }

    @Override
    public T remover(int posicao) {
        if (posicao < 0 || posicao >= this.quantidadeNos) {
            throw new IndexOutOfBoundsException();
        }
        T dadoRemovido;
        if (posicao == 0) {
            dadoRemovido = this.primeirNo.obterElemento();
            this.removerInicio();
        } else if (posicao == this.quantidadeNos - 1) {
            dadoRemovido = this.ultimoNo.obterElemento();
            this.removerFim();
        } else {
            INoListaSimplesmenteEncadeada<T> noAnterior = this.primeirNo;
            for (int i = 0; i < posicao - 1; i++) {
                noAnterior = noAnterior.obterProximoNo();
            }
            dadoRemovido = noAnterior.obterProximoNo().obterElemento();
            noAnterior.definirProximoNo(noAnterior.obterProximoNo().obterProximoNo());
            this.quantidadeNos--;
        }
        return dadoRemovido;
    }

    @Override
    public void limpar() {
        this.primeirNo = null;
        this.ultimoNo = null;
        this.quantidadeNos = 0;
    }

    ////////////////////////////////////////////////////////////////
    //Operações Derivadas de Mutação (Derived Mutation Operations)//
    ////////////////////////////////////////////////////////////////

    @Override
    public void remover(T elemento) {
        int pos = this.posicao(elemento);
        if (pos != -1) {
            this.remover(pos);
        }
    }



    ////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations)//
    ////////////////////////////////////////////////

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            INoListaSimplesmenteEncadeada<T> noAtual = primeirNo;

            @Override
            public boolean hasNext() {
                if (noAtual != null) {
                    return true;
                } else {
                    this.noAtual = primeirNo;
                    return false;
                }
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