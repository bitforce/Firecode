package source.lvl4.p15;
import source.temp.help.MatrixPrinter;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static int[][] rotate(int[][] matrix) {
        final int N = matrix.length;
        int[][] m = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                m[j][N-i-1] = matrix[i][j];
        return m;
    }
    /* ********************************************************************* */
    private static int[][] rotate2(int[][] matrix) {
        final int N = matrix.length;
        for (int i = 0; i < N / 2; i++) {
          for (int j = 0; j < Math.ceil(((double) N) / 2.); j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[N-1-j][i];
            matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
            matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
            matrix[j][N-1-i] = temp;
          }
        }
        return matrix;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int l = args.length;
        if(Math.sqrt(l) != Math.floor(Math.sqrt(l))) return;
        int s = (int) Math.sqrt(l);
        int[][] matrix = new int[s][s];
        int[] arr = new int[l];
        for (int i = 0; i < l; i++)
            arr[i] = Integer.parseInt(args[i]);
        int e = 0;
        for(int i = 0; i < s; i++)
            for(int j = 0; j < s; j++) {
                matrix[i][j] = arr[e++];
            }
        MatrixPrinter.print(matrix);
        System.out.println();
        MatrixPrinter.print(rotate(matrix));
        System.out.println();
        MatrixPrinter.print(rotate2(matrix));
    }
}
