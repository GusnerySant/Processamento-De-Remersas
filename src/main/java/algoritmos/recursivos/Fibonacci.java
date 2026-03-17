package algoritmos.recursivos;

import java.util.Arrays;

public class Fibonacci {

    public static int[] vetorSubProblemas;

    public static int fibonacciRecursivo(int n){
        if ((n == 0) || (n == 1)){
            return n;
        }
        else {
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }
    }

    public static int fibonacciIterativo(int n) {
        int i, fibonacci = 0;
        int fibAnterior = 0;
        int fibPosterior = 1;
        if ((n == 0) || (n == 1)){
            return n;
        }
        else {
            for (i = 2; i <= n; i++){
                fibonacci = fibAnterior + fibPosterior;
                fibAnterior = fibPosterior;
                fibPosterior = fibonacci;
            }
            return fibonacci;
        }
    }

    public static int fibonacciRecursivoMemorizado(int n) {
        vetorSubProblemas = new int[n + 1];
        Arrays.fill(vetorSubProblemas, -1);

        vetorSubProblemas[0] = 0;
        if (n > 0) vetorSubProblemas[1] = 1;

        return fibonacciRecursivoTopDown(n);
    }

    public static int fibonacciRecursivoTopDown(int n) {
        if (vetorSubProblemas[n] == -1) {
            vetorSubProblemas[n] = fibonacciRecursivoTopDown(n - 1) + fibonacciRecursivoTopDown(n - 2);
        }
        return vetorSubProblemas[n];
    }


    public static void main(String[] args) {
        int n = 40;
        vetorSubProblemas = new int[n];

        //Medição do tempo para versão recursiva
        long inicioRecursivo = System.nanoTime();
        int resultadoRecursivo = fibonacciRecursivo(n);
        long fimRecursivo = System.nanoTime();
        long tempoRecursivo = fimRecursivo - inicioRecursivo;

        //Medição do tempo para versão iterativa
        long inicioIterativo = System.nanoTime();
        int resultadoIterativo = fibonacciIterativo(n);
        long fimIterativo = System.nanoTime();
        long tempoIterativo = fimIterativo - inicioIterativo;

        //Medição do tempo para versão recursiva memoizada
        long inicioRecursivoMemorizado = System.nanoTime();
        int resultadoRecursivoMemorizado = fibonacciRecursivoMemorizado(n);
        long finalRecursivoMemorizado = System.nanoTime();
        long tempoRecursivoMemorizado = finalRecursivoMemorizado - inicioRecursivoMemorizado;

        //Apresentação dos Resultados Medidos
        System.out.println("Resultado recursivo: " + resultadoRecursivo);
        System.out.println("Tempo recursivo (ns): " + tempoRecursivo);
        System.out.println("Resultado iterativo: " + resultadoIterativo);
        System.out.println("Tempo iterativo (ns): " + tempoIterativo);
        System.out.println("Diferença (ns): " + (tempoRecursivo - tempoIterativo));
        System.out.println("Resultado recursivo memorizado: " + resultadoRecursivoMemorizado);
        System.out.println("Tempo recursivo memorizado (ns): " + tempoRecursivoMemorizado);
        System.out.println("Diferença entre recursivo memorizado e recursivo (ns): " + Math.abs(tempoRecursivoMemorizado - tempoRecursivo));
        System.out.println("Diferença entre recursivo memorizado e iterativo (ns): " + Math.abs(tempoRecursivoMemorizado - tempoIterativo));
    }

}
