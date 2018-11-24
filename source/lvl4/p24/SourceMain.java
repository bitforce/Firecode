package source.lvl4.p24;

import source.support.print.MatrixPrinter;

import static source.lvl4.p24.Source.matrixMaxSumDP;
import static source.lvl4.p24.Source.matrixMaxSumDP2;

public class SourceMain {
    public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        int[][] matrix = new int[M][N];
        int[] arr = new int[args.length-2];
        for (int i = 0; i < args.length-2; i++)
            arr[i] = Integer.parseInt(args[i+2]);
        for(int i = 0; i < M; i++)
            System.arraycopy(arr, i*N, matrix[i], 0, N);
        MatrixPrinter.print(matrix);
        System.out.println(matrixMaxSumDP(matrix));
        System.out.println(matrixMaxSumDP2(matrix));
    }
}
