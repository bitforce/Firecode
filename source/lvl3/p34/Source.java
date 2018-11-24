package source.lvl3.p34;
import source.support.print.MatrixPrinter;

class Source {
    static void rotateSquareImageCCW(final int[][] matrix) {
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
    static void rotateSquareImageCCW2(final int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }
    private static void transpose(final int[][] matrix) {
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
        final int C = matrix[0].length - 1;
        int r = matrix.length - 1;
        int temp = 0;
        for(int i = 0; i <= r/2; i++)
            for(int j = r; j <= C; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[r-i][j];
                matrix[r=i][j] = temp;
            }
    }
}
