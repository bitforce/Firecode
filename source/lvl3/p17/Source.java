package source.lvl3.p17;

class Source {
    static void rotateSquareImageCW(final int[][] matrix) {
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
    static void rotateSquareImageCW2(final int[][] mat) {
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
}
