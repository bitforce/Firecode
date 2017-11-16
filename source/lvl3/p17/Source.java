package source.lvl3.p17;
import source.temp.help.MatrixPrinter;
import java.util.*;
class Source {
    private static void rotateSquareImageCW(int[][] matrix) {
        if(matrix == null) return;
        final int LEN = matrix.length;
        int temp1;
        int temp2;
        for(int i = 0, k = LEN-1; i < k; ++i, --k) {
            int[] temp = matrix[i];
            matrix[i] = matrix[k];
            matrix[k] = temp;
        }
        for(int i = 0; i < LEN; i++)
            for(int j = i; j < LEN; j++) {
                temp1 = matrix[i][j];
                temp2 = matrix[j][i];
                matrix[i][j] = temp2;
                matrix[j][i] = temp1;
            }
    }
    /* ********************************************************************* */
    public static void rotateSquareImageCW2(int[][] mat) {
        final int N = mat.length;
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N-x-1; y++){
                int temp = mat[x][y];
                mat[x][y] = mat[N-y-1][x];
                mat[N-y-1][x] = mat[N-x-1][N-y-1];
                mat[N-x-1][N-y-1] = mat[y][N-x-1];
                mat[y][N-x-1] = temp;
            }
        }
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] array = new int[args.length];
        for(int i = 0; i < array.length; i++) 
            array[i] = Integer.parseInt(args[i]);
        int length = Integer.parseInt(args[array.length-1]);
        int[][] matrix = new int[length][length];
        for(int r = 0; r < length; r++)
            for(int c = 0; c < length; c++)
                matrix[r][c] = array[c % matrix[0].length + (r * matrix[0].length)];
        MatrixPrinter.print(matrix);
        rotateSquareImageCW(matrix);
        System.out.println(); 
        MatrixPrinter.print(matrix);
        System.out.println();
        rotateSquareImageCW2(matrix);
        MatrixPrinter.print(matrix);
    }
}
