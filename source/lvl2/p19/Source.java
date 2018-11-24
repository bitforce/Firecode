package source.lvl2.p19;
import source.support.print.MatrixPrinter;
class Source {
   /* ********************************************************************** */ 
    private static void tranposeMatrix(int[][] matrix) {
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
    private static void tranposeMatrix2(int[][] matrix) {
        int temp;
        int len = matrix.length;
        for(int r = 0; r < len; r++)
            for(int c = r+1; c < len; c++) {
                temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
    }
   /* ********************************************************************** */ 
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
        System.out.println(); 
        tranposeMatrix(matrix);
        MatrixPrinter.print(matrix);
        System.out.println();
        tranposeMatrix2(matrix);
        MatrixPrinter.print(matrix);
    }
}
