package source.lvl3.p34;
import source.temp.help.MatrixPrinter;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static void rotateSquareImageCCW(int[][] matrix) {
        final int N = matrix.length;
        for(int i = 0; i < N/2; i++)
            for(int j = i; j < N-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][N-i-1];
                matrix[j][N-i-1] = matrix[N-i-1][N-j-1];
                matrix[N-i-1][N-j-1] = matrix[N-j-1][i];
                matrix[N-j-1][i] = temp;
            }
    }
    /* ********************************************************************* */
    private static void rotateSquareImageCCW2(int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }
    private static void transpose(int[][] matrix) {
        final int N = matrix.length-1;
        int temp = 0;
        for(int i = 0; i <= N; i++)
            for(int j = i+1; j <= N; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }
    private static void flip(int[][] matrix) {
        int r = matrix.length - 1;
        int C = matrix[0].length - 1;
        int temp = 0;
        for(int i = 0; i <= r/2; i++)
            for(int j = r; j <= C; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[r-i][j];
                matrix[r=i][j] = temp;
            }
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        final int N = (int) Math.sqrt(arr.length);
        int[][] matrix = new int[N][N];
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
