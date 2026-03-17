package laboratorio.desafios.remessasemdeposito;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppGerenciadorRemessaDeposito {

    public static void main(String[] args) {

        IGerenciadorRemessaDeposito depositoCEASAAJU = new GerenciadorRemessaDeposito();

        System.out.println("\n");
        System.out.println("###########################################################");
        System.out.println("### Gerenciador de Remessas em Deposito - CEASA ARACAJU ### ");
        System.out.println("########################################################### ");

        /////////////////////////////////////////////////////////////////////
        //Criando Remessas de Exemplo                                      //
        //Simulando o recebimento de remessas oriundas de outros municípios//
        /////////////////////////////////////////////////////////////////////

        //Cria a Remessa de Mercadores Oriundas de Lagarto
        IItemEstoque[] remessaDeLagarto = {
                new ItemEstoque("CebolaRoxa", 100, LocalDate.of(2026, 06, 24)),
                new ItemEstoque("Batata", 150, LocalDate.of(2026, 05, 14))
        };

        //Cria a Remessa de Mercadores Oriundas de Itabaiana
        IItemEstoque[] remessaDeItabaiana = {
                new ItemEstoque("CebolaRoxa", 500, LocalDate.of(2026, 03, 02)),
                new ItemEstoque("CebolaBranca", 100, LocalDate.of(2026, 2, 06)),
                new ItemEstoque("Batata", 100, LocalDate.of(2026, 05, 14))
        };

        //Cria a Remessa de Mercadores Oriundas de Capela
        IItemEstoque[] remessaDeCapela = {
                new ItemEstoque("CebolaRoxa", 350, LocalDate.of(2026, 04, 23)),
                new ItemEstoque("Laranja", 120, LocalDate.of(2026, 12, 25)),
                new ItemEstoque("Uva", 1000, LocalDate.of(2026, 05, 20))
        };

        ////////////////////////////////////////////////////////
        //Recebendo as Remessas de Lagarto, Itabaiana e Capela//
        ////////////////////////////////////////////////////////

        System.out.println("\n");
        System.out.println("[Etapa 01 - Recebendo as Remessas de Mercadorias Oriundas de Lagarto, Itabaiana e Capela Em Ordem de Chegada] \r\n");

        depositoCEASAAJU.receberRemessa(remessaDeLagarto);
        System.out.println("    1º Remessa de Lagarto Recebida com Dois Itens (Cebola Roxa e Batata)");

        depositoCEASAAJU.receberRemessa(remessaDeItabaiana);
        System.out.println("    2º Remessa de Itabiaana Recebida com Três Itens (Cebola Roxa, Cebola Branca e Batata)");

        depositoCEASAAJU.receberRemessa(remessaDeCapela);
        System.out.println("    3º Remessa de Capela Recebida com Três Itens (Cebola Roxa, Laranja e Uva)");

        //////////////////////////////////////////////////////////////
        //Verificando Status do Armazenamento Antes do Processamento//
        //////////////////////////////////////////////////////////////

        System.out.println("\n");
        System.out.println("[Etapa 02 - Status Do Armazenamento no Depósito Antes do Processamento das Remessas] \r\n");

        System.out.println("    Tem Remessas Recebidas Pendentes de Processamento? " + (depositoCEASAAJU.temRemessasRecebidasPendentesDeProcessamento() ? "SIM" : "NÃO"));
        imprimirStatusArmazenamento(depositoCEASAAJU.obterStatusArmazenamento());

        /////////////////////////////////
        //Processando Todas as Remessas//
        /////////////////////////////////

        System.out.println("\n");
        System.out.println("[Etapa 03 - Processando Todas as Remessas] \r\n");
        depositoCEASAAJU.processarTodasRemessas();
        System.out.println("    Todas as Remessas Processadas");

        ////////////////////////////////////////////////////////////
        //Verificando Status do Armazenamento Após o Processamento//
        ////////////////////////////////////////////////////////////

        System.out.println("\n");
        System.out.println("[Etapa 04 - Status Do Armazenamento no Depósito Após o Processamento das Remessas] \r\n");

        System.out.println("    Tem Remessas Recebidas Pendentes de Processamento? " + (depositoCEASAAJU.temRemessasRecebidasPendentesDeProcessamento() ? "Sim" : "Não"));
        imprimirStatusArmazenamento(depositoCEASAAJU.obterStatusArmazenamento());

        ///////////////////////////////////////////////////////////////////////////////////////
        //Recuperando Próximo Item (Data de Validade Mais Próxima) de Uma Determinada Remessa//
        ///////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\n");
        System.out.println("[Etapa 05 - Recuperando Próximo Item (Data de Validade Mais Próxima) de Uma Determinada Remessa Armazenada no Depósito] \r\n");

        System.out.println("    Recuperando Próximo Item da Remessa de Cebola Roxa");
        IItemEstoque itemRecuperadoA = depositoCEASAAJU.recuperarProximoItemDaRemessa("CebolaRoxa");
        System.out.println("     - Recuperando do Armazenamento: " + itemRecuperadoA + " (Data de Validade Mais Próxima: " + itemRecuperadoA.obterDataValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))   + ") \r\n");

        System.out.println("    Recuperando Próximo Item da Remessa de Cebola Roxa");
        IItemEstoque itemRecuperadoB = depositoCEASAAJU.recuperarProximoItemDaRemessa("CebolaRoxa");
        System.out.println("     - Recuperando do Armazenamento: " + itemRecuperadoB + " (Data de Validade Mais Próxima: " + itemRecuperadoB.obterDataValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))   + ") \r\n");

        System.out.println("    Recuperando Próximo Item da Remessa de Uva");
        IItemEstoque itemRecuperadoC = depositoCEASAAJU.recuperarProximoItemDaRemessa("Uva");
        System.out.println("     - Recuperando do Armazenamento: " + itemRecuperadoC + " (Data de Validade Mais Próxima: " + itemRecuperadoC.obterDataValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))  + ") \r\n");

        System.out.println("    Tentando Recuperar de Uma Remessa Que Não Existe - Melancia ");
        IItemEstoque itemRecuperadoNaoExistente = depositoCEASAAJU.recuperarProximoItemDaRemessa("Melancia");
        System.out.println("     - Recuperando do Armazenamento: " + (itemRecuperadoNaoExistente == null ? " Não Existe " : "Item Inesperado \r\n"));

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //Verificando Status do Armazenamento Após Recuperação de Itens Com Data de Validade Mais Próxima//
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\r\n");
        System.out.println("[Etapa 06 - Verificando Status do Armazenamento Após Recuperação de Itens Com Data de Validade Mais Próxima da Remessa de Cebola Roxa e Uva] \r\n");
        imprimirStatusArmazenamento(depositoCEASAAJU.obterStatusArmazenamento());
        System.out.println("\r\n");

    }

    public static void imprimirStatusArmazenamento(String statusArmazenamento) {
        if (statusArmazenamento.isEmpty()) {
            System.out.println("    Itens Armazenados no Depósito? NÃO");
        } else {
            System.out.println("    Itens Armazenados no Depósito? SIM \r\n");
            String[] Itens = statusArmazenamento.split("\n");
            for (String Item : Itens) {
                System.out.println("     - " + Item);
            }
        }

    }

}