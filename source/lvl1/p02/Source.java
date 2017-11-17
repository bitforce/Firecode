package source.lvl1.p02;
import source.temp.help.MatrixPrinter;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static void flipItVerticalAxis(int[][] matrix) {
        int temp = 0;
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        for (int r = 0; r < rowlen; r++)
            for (int c = 0; c < collen / 2; c++) {
                temp = matrix[r][c];
                matrix[r][c] = matrix[r][collen - c - 1];
                matrix[r][collen - c - 1] = temp;
            }
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        int e = 2;
        int[][] matrix = new int[arr[0]][arr[1]];
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = arr[e];
                e++;
            }
        MatrixPrinter.print(matrix);
        flipItVerticalAxis(matrix);
        System.out.println();
        MatrixPrinter.print(matrix);
    }
}
