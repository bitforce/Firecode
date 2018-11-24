package source.lvl4.p19;

import source.support.print.MatrixPrinter;

import static source.lvl4.p19.Source.matrixMaxSumDfs;
import static source.lvl4.p19.Source.matrixMaxSumDfs2;
import static source.lvl4.p19.Source.matrixMaxSumDfs3;

public class SourceMain {
    public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        final int[][] matrix = new int[M][N];
        final int[] arr = new int[args.length-2];
        for (int i = 0; i < args.length-2; i++)
            arr[i] = Integer.parseInt(args[i+2]);
        for(int i = 0; i < M; i++)
            System.arraycopy(arr, i*N, matrix[i], 0, N);
        MatrixPrinter.print(matrix);
        System.out.println(matrixMaxSumDfs(matrix));
        System.out.println(matrixMaxSumDfs2(matrix));
        System.out.println(matrixMaxSumDfs3(matrix));
    }
}
