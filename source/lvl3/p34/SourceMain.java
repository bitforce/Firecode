package source.lvl3.p34;

import source.support.print.MatrixPrinter;

import static source.lvl3.p34.Source.rotateSquareImageCCW;
import static source.lvl3.p34.Source.rotateSquareImageCCW2;

public class SourceMain {
     public static void main(String[] args) {
        final int[] arr = new int[args.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        final int N = (int) Math.sqrt(arr.length);
        final int[][] matrix = new int[N][N];
        for(int r = 0; r < N; r++)
            for(int c = 0; c < N; c++)
                matrix[r][c] = arr[c % N + (r * N)];
        MatrixPrinter.print(matrix);
        rotateSquareImageCCW(matrix);
        System.out.println();
        MatrixPrinter.print(matrix);
        System.out.println();
        rotateSquareImageCCW2(matrix);
        MatrixPrinter.print(matrix);
    }
}
