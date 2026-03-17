package algoritmos.busca;

public class BuscaBinaria {

    // Versão Iterativa

    public static int buscaBinariaIterativa(int[] vetor, int valor) {
        if (vetor == null) return -1;

        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == valor) {
                return meio;
            } else if (valor < vetor[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return -1;
    }

    // Versão Recursiva

    public static int buscaBinariaRecursiva(int[] vetor, int valor) {
        if (vetor == null) return -1;
        return buscaBinariaRecursiva(vetor, valor, 0, vetor.length - 1);
    }

    private static int buscaBinariaRecursiva(int[] vetor, int valor, int inicio, int fim) {

        if (inicio > fim) {
            return -1;
        }

        int meio = (inicio + fim) / 2;

        if (vetor[meio] == valor) {
            return meio;
        } else if (valor < vetor[meio]) {
            return buscaBinariaRecursiva(vetor, valor, inicio, meio - 1);
        } else {
            return buscaBinariaRecursiva(vetor, valor, meio + 1, fim);
        }
    }

}