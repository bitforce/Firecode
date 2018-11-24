package source.lvl4.p15;

class Source {
    static int[][] rotate(final int[][] matrix) {
        final int N = matrix.length;
        final int[][] m = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                m[j][N-i-1] = matrix[i][j];
        return m;
    }
    /* ********************************************************************* */
    static int[][] rotate2(final int[][] matrix) {
        final int N = matrix.length;
        for (int i = 0; i < N / 2; i++) {
          for (int j = 0; j < Math.ceil(((double) N) / 2.); j++) {
            final int temp = matrix[i][j];
            matrix[i][j] = matrix[N-1-j][i];
            matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
            matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
            matrix[j][N-1-i] = temp;
          }
        }
        return matrix;
    }
}
