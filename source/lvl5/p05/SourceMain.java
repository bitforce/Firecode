package source.lvl5.p05;

import source.support.print.MatrixPrinter;

import static source.lvl5.p05.Source.largestSquare;
import static source.lvl5.p05.Source.largestSquare2;

public class SourceMain {
     public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        final int L = args.length-2;
        final char[][] matrix = new char[M][N];
        final char[] arr = new char[L];
        for(int i = 0; i < L; i++)
            arr[i] = args[i+2].charAt(0);
        for(int i = 0; i < M; i++)
          System.arraycopy(arr, i*N, matrix[i], 0, N);
        MatrixPrinter.print(matrix);
        System.out.println(largestSquare(matrix));
        System.out.println(largestSquare2(matrix));
    }
}
