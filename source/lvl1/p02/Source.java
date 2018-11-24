package source.lvl1.p02;

class Source {
    static void flipItVerticalAxis(int[][] matrix) {
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
}
