package source.lvl1.p10;
import source.temp.help.MatrixPrinter;
class Source {
    /* ********************************************************************* */
    private static void flipHorizontalAxis(int[][] matrix) {
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
        flipHorizontalAxis(matrix);
        System.out.println();
        MatrixPrinter.print(matrix);
    }
}
