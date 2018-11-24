package source.lvl1.p10;

class Source {
    static void flipHorizontalAxis(int[][] matrix) {
        int temp;
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        for(int r = 0; r < rowlen/2; r++)
            for(int c = 0; c < collen; c++) {
                temp = matrix[r][c];
                matrix[r][c] = matrix[rowlen-r-1][c];
                matrix[rowlen-r-1][c] = temp;
            }
    }
}
