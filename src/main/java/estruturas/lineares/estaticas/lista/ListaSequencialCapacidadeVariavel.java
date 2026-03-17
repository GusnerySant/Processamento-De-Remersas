package estruturas.lineares.estaticas.lista;

import estruturas.lineares.IListaLinear;

import java.util.Iterator;

public class ListaSequencialCapacidadeVariavel<T> implements IListaLinear<T>, Iterable<T> {

    /////////////
    //Atributos//
    /////////////

    private static final int CAPACIDADE_PADRAO = 10;
    private ListaSequencial<T> lista;   //Associação Estrutural - Composição - A partir de atributo
    private int capacidade;

    //////////////
    //Construtor//
    //////////////

    public ListaSequencialCapacidadeVariavel() {
        this(CAPACIDADE_PADRAO);
    }

    public ListaSequencialCapacidadeVariavel(int capacidade) {
        if (capacidade < 0) {
            throw new IllegalArgumentException("A capacidade do vetor não pode ser negativa");
        }
        this.capacidade = capacidade;
        this.lista = new ListaSequencial<>(capacidade);
    }

    ////////////////////////
    //Operações Auxiliares//
    ////////////////////////

    //Retorna a capacidade da lista
    public int capacidade() {
        return this.capacidade;
    }

    //Verifica a capacidade do vetor
    private void verificarCapacidade() {
        if (this.lista.tamanho() == capacidade) {
            int novaCapacidade = capacidade == 0 ? 1 : capacidade * 2;
            this.redimensionar(novaCapacidade);
        }
    }

    //Verifica a capacidade de redução do vetor
    private void verificaCapacidadeReducao() {
        if (this.lista.tamanho() > 0 && this.lista.tamanho() < capacidade / 4) {
            int novaCapacidade = Math.max(capacidade / 2, CAPACIDADE_PADRAO);
            this.redimensionar(novaCapacidade);
        }
    }

    //Redimensiona o vetor em tempo de execução
    private void redimensionar(int novaCapacidade) {
        if (novaCapacidade < this.lista.tamanho()) {
            throw new IllegalStateException("Nova capacidade não pode ser menor que o tamanho atual");
        }

        //Cria nova lista com a nova capacidade
        ListaSequencial<T> novaLista = new ListaSequencial<>(novaCapacidade);

        //copia todos os elementos da lista antiga para a nova
        for (int i = 0; i < this.lista.tamanho(); i++) {
            novaLista.inserir(this.lista.obter(i), i);
        }

        this.lista = novaLista;
        this.capacidade = novaCapacidade;
    }

    ////////////////////////////////////////////
    //Operações de Consulta (Query Operations)//
    ////////////////////////////////////////////

    @Override
    public int tamanho() {
        return this.lista.tamanho();
    }

    @Override
    public boolean estaVazia() {
        return this.lista.estaVazia();
    }

    @Override
    public int posicao(T elemento) {
        return this.lista.posicao(elemento);
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
    public T obter(int posicao) {
        return this.lista.obter(posicao);
    }

    public boolean estaCheia() {
        return this.lista.tamanho() == capacidade;
    }

    ////////////////////////////////////////////////////////////
    //Operações Básicas de Mutação (Basic Mutation Operations)//
    ////////////////////////////////////////////////////////////

    @Override
    public void inserir(T elemento, int posicao) {
        this.verificarCapacidade();
        this.lista.inserir(elemento, posicao);
    }

    @Override
    public void atualizar(int posicao, T elemento) {
        this.lista.atualizar(posicao, elemento);
    }

    @Override
    public T remover(int posicao) {
        T elementoRemovido = this.lista.remover(posicao);
        this.verificaCapacidadeReducao();
        return elementoRemovido;
    }

    @Override
    public void limpar() {
        this.lista.limpar();
        this.redimensionar(CAPACIDADE_PADRAO);
    }

    ////////////////////////////////////////////////////////////////
    //Operações Derivadas de Mutação (Derived Mutation Operations)//
    ////////////////////////////////////////////////////////////////

    public void inserirInicio(T elemento) {
        this.verificarCapacidade();
        this.lista.inserirInicio(elemento);
    }

    public void removerElemento(T elemento) {
        this.lista.removerElemento(elemento);
        this.verificaCapacidadeReducao();
    }

    public void removerInicio() {
        this.lista.removerInicio();
        this.verificaCapacidadeReducao();
    }

    public void removerFim() {
        this.lista.removerFim();
        this.verificaCapacidadeReducao();
    }

    public void inserirEmLote(T[] novosElementos) {
        if (novosElementos == null || novosElementos.length == 0) {
            return;
        }

        int tamanhoAtual = this.lista.tamanho();
        int tamanhoFinal = tamanhoAtual + novosElementos.length;

        if (tamanhoFinal > capacidade) {
            int novaCapacidade = capacidade;

            while (novaCapacidade < tamanhoFinal) {
                novaCapacidade = (novaCapacidade == 0) ? 1 : novaCapacidade * 2;
            }

            this.redimensionar(novaCapacidade);
        }

        for (T elemento : novosElementos) {
            this.lista.inserir(elemento, this.lista.tamanho());
        }
    }

    ////////////////////////////////////////////////
    //Operações de Iteração (Iteration Operations)//
    ////////////////////////////////////////////////

    @Override
    public Iterator<T> iterator() {
        return this.lista.iterator();
    }

}