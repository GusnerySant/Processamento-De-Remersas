package algoritmos.busca;

public class BuscaSequencial {

    public static int buscaSequencial(int[] vetor, int valor) {
        if (vetor == null) return -1;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor) {
                return i;
            }
        }
        return -1;
    }

}