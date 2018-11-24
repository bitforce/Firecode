package source.lvl5.p05;
import source.support.print.MatrixPrinter;

class Source {
    /* ********************************************************************* */
    private static int largestSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        final int M = matrix.length;
        final int N = matrix[0].length;
        final int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++)
            grid[i][0] = Character.getNumericValue(matrix[i][0]);
        for (int j = 0; j < N; j++)
            grid[0][j] = Character.getNumericValue(matrix[0][j]);
        for (int i = 1; i < M; i++)
            for (int j = 1; j < N; j++)
                if (matrix[i][j] == '1') {
                    int min = Math.min(grid[i-1][j], grid[i-1][j-1]);
                    min = Math.min(min,grid[i][j-1]);
                    grid[i][j] = min + 1;
                } else grid[i][j] = 0;
        int max = 0;
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (grid[i][j] > max)
                    max = grid[i][j];
        return max * max;
    }
    /* ********************************************************************* */
    private static int largestSquare2(char[][] matrix) {
        int temp = 0, upperLeft = 0, max = 0;
        int[] curr = new int[matrix[0].length + 1];
        for(int i = 1; i <= matrix.length; i++)
            for(int j = 1; j <= matrix[0].length; j++) {
                temp = curr[j];
                if(matrix[i - 1][j - 1] == '1') 
                    curr[j] = Math.min(Math.min(curr[j], upperLeft), curr[j - 1]) + 1;
                else
                    curr[j] = 0;
                upperLeft = temp;
                max = Math.max(max, curr[j]);
            }
        return max * max;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        final int L = args.length-2;
        final char[][] matrix = new char[M][N];
        final char[] arr = new char[L];
        for(int i = 0; i < L; i++)
            arr[i] = args[i+2].charAt(0);
        for(int i = 0; i < M; i++)
          System.arraycopy(arr, i*N, matrix[i], 0, N);
        MatrixPrinter.print(matrix);
        System.out.println(largestSquare(matrix));
        System.out.println(largestSquare2(matrix));
    }
}
