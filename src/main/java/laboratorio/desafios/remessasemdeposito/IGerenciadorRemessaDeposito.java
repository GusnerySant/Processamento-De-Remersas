package laboratorio.desafios.remessasemdeposito;

public interface IGerenciadorRemessaDeposito {

    //Define os métodos principais para gerenciamento do depósito.

    //Recebe remessas de mercadorias para armazenamento no depósito
    void receberRemessa(IItemEstoque[] remessa);

    //Organiza as remessas de mercadorias que chegaram para armazenamento recentemente
    void processarTodasRemessas();

    //Processa remessas individualmente, ou seja, uma remessa por vez
    //Esse método deve usar o método de ordenação por inserção
    void processarUmaUnicaRemessa(IItemEstoque[] remessa);

    //Fornece uma visão geral do estoque atual
    String obterStatusArmazenamento();

    //Recupeara o próximo item da remessa. O próximo item deve ser sempre o com data de validade mais próxima
    //Obs.: O método não pode recuperar o próximo item percorrendo todos os elementos e buscando a data mais próxima, ou seja, esse método não pode fazer uso de estrutura de repetição
    //Portanto deve-se usar uma estrutura de dados que armazene as datas de validade mais próximas de forma a ser recuperado sem necessidade de estrutura de repetição
    IItemEstoque recuperarProximoItemDaRemessa(String ID);

    //Indica se tem remessas recebidas pendentes de processamento no depósito
    boolean temRemessasRecebidasPendentesDeProcessamento();

}