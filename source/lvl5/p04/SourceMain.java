package source.lvl5.p04;

import source.support.print.MatrixPrinter;

import static source.lvl5.p04.Source.minWeightedPath;
import static source.lvl5.p04.Source.minWeightedPath2;
import static source.lvl5.p04.Source.minWeightedPath3;

public class SourceMain {
     public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        final int L = args.length-2;
        final int[][] matrix = new int[M][N];
        final int[] arr = new int[L];
        for(int i = 0; i < L; i++)
            arr[i] = Integer.parseInt(args[i+2]);
        for(int i = 0; i < M; i++)
          System.arraycopy(arr, i*N, matrix[i], 0, N);
        MatrixPrinter.print(matrix);
        System.out.println(minWeightedPath(matrix));
        System.out.println(minWeightedPath2(matrix));
        System.out.println(minWeightedPath3(matrix));
    }
}
