package laboratorio.desafios.remessasemdeposito;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ItemEstoque implements IItemEstoque {

    //Essa classe concreta representa um item de estoque com ID, quantidade e data de validade.

    private final String ID;
    private final int quantidade;
    private final LocalDate dataValidade;

    private static final DateTimeFormatter FMT_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ItemEstoque(String ID, int quantidade, LocalDate dataValidade) {
        this.ID = ID;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
    }

    @Override
    public String obterID() {
        return this.ID;
    }

    @Override
    public int obterQuantidade() {
        return this.quantidade;
    }

    @Override
    public LocalDate obterDataValidade() {
        return this.dataValidade;
    }

    public String toString() {
        return String.format("[Quantidade: %s , Data Validade: %s]", this.quantidade, this.dataValidade.format(FMT_DATA));
    }

}