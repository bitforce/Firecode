package source.lvl2.p19;

class Source {
    static void tranposeMatrix(int[][] matrix) {
        int tmp1, tmp2;
        int len = matrix.length;
        for(int i = 0; i < len; i++) 
            for(int j = i; j < len; j++) {
                tmp1 = matrix[i][j];
                tmp2 = matrix[j][i];
                matrix[i][j] = tmp2;
                matrix[j][i] = tmp1;
            }
    }
   /* ********************************************************************** */ 
    static void tranposeMatrix2(int[][] matrix) {
        int temp;
        int len = matrix.length;
        for(int r = 0; r < len; r++)
            for(int c = r+1; c < len; c++) {
                temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
    }
}
