package laboratorio.desafios.remessasemdeposito;

import java.time.LocalDate;

public interface IItemEstoque {

    //Essa interface define os atributos essenciais dos itens de estoque do depósito

    //Retorna o identificador da unidade de manutenção de estoque
    //Ex.: ID01
    String obterID();

    //Retorna a quantidade de itens neste lote
    int obterQuantidade();

    //Retorna a data de validade, ou seja, data em que este lote se torna sem validade
    LocalDate obterDataValidade();

}