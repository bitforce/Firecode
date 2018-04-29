package source.lvl4.p24;
import source.temp.help.MatrixPrinter;
import java.util.*;
import static java.lang.Math.max;
class Source {
    /* ********************************************************************* */
    private static int matrixMaxSumDP(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        final int M = grid.length;
        final int N = grid[0].length;
        int[][] memo = new int[M][N];
        for(int i = 1; i < M; i++) memo[i][0] = memo[i-1][0] + grid[i][0];
        for(int i = 1; i < N; i++) memo[0][i] = memo[0][i-1] + grid[0][i];
        for(int i = 1; i < M; i++)
            for(int j = 1; j < N; j++)
                memo[i][j] = grid[i][j] + max(memo[i-1][j], memo[i][j-1]);
        return memo[M-1][N-1] + grid[0][0];
    }
    /* ********************************************************************* */
    public static int matrixMaxSumDP2(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        final int M = grid.length;
        final int N = grid[0].length;
        int dp[] = new int[N+1];
        for (int r = 0; r < M; r++)
            for (int c = 1; c <= N; c++)
                dp[c] = Math.max(dp[c - 1], dp[c]) + grid[r][c - 1];
        return dp[N];
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        int[][] matrix = new int[M][N];
        int[] arr = new int[args.length-2];
        for (int i = 0; i < args.length-2; i++)
            arr[i] = Integer.parseInt(args[i+2]);
        for(int i = 0; i < M; i++)
            System.arraycopy(arr, i*N, matrix[i], 0, N);
        MatrixPrinter.print(matrix);
        System.out.println(matrixMaxSumDP(matrix));
        System.out.println(matrixMaxSumDP2(matrix));
    }
}
