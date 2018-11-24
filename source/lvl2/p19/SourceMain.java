package source.lvl2.p19;

import source.support.print.MatrixPrinter;

import static source.lvl2.p19.Source.tranposeMatrix;
import static source.lvl2.p19.Source.tranposeMatrix2;

public class SourceMain {
     public static void main(String[] args) {
        int[] arr = new int[args.length];
        for(int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        int e = 2;
        int[][] matrix = new int[arr[0]][arr[1]];
        for(int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = arr[e];
                e++;
            }
        MatrixPrinter.print(matrix);
        System.out.println();
        tranposeMatrix(matrix);
        MatrixPrinter.print(matrix);
        System.out.println();
        tranposeMatrix2(matrix);
        MatrixPrinter.print(matrix);
    }
}
