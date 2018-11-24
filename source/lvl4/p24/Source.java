package source.lvl4.p24;

import static java.lang.Math.max;

class Source {
    static int matrixMaxSumDP(final int[][] grid) {
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
    static int matrixMaxSumDP2(final int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        final int N = grid[0].length;
        int dp[] = new int[N+1];
        for (int[] aGrid : grid)
            for (int c = 1; c <= N; c++)
                dp[c] = Math.max(dp[c - 1], dp[c]) + aGrid[c - 1];
        return dp[N];
    }
}
