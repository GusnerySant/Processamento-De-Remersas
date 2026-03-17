package algoritmos.busca;

import java.util.Arrays;

public class AppBusca {


    public static void main(String[] args) {

        int valor = 3; //Valor a ser buscado nos arrays

        //Busca Sequencial

        int[] dados = {7, 3, 9, 1, 4, 5, 8, 2};
        System.out.println("Array: " + Arrays.toString(dados));

        int posicao = BuscaSequencial.buscaSequencial(dados, valor);
        System.out.println("----Busca Sequencial----");
        if (posicao >= 0) {
            System.out.printf("Valor %d Encontrado na posição %d: \n", valor, posicao);
        } else {
            System.out.println("Não encontrado");
        }

        Arrays.sort(dados);
        System.out.println("Array(sort): " + Arrays.toString(dados));

        int posicaoBinariaIterativa = BuscaBinaria.buscaBinariaIterativa(dados, valor);
        System.out.println("----Busca Binária Iterativa----");
        if (posicaoBinariaIterativa >= 0) {
            System.out.printf("Valor %d Encontrado na posição %d: \n", valor, posicaoBinariaIterativa);
        } else {
            System.out.println("Não encontrado");
        }

        int posicaoBinariaRecursiva = BuscaBinaria.buscaBinariaRecursiva(dados, valor);
        System.out.println("----Busca Binária Recursiva----");
        if (posicaoBinariaRecursiva >= 0) {
            System.out.printf("Valor %d Encontrado na posição %d: \n", valor, posicaoBinariaRecursiva);
        } else {
            System.out.println("Não encontrado");
        }

    }

}