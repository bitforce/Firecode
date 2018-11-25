package source.lvl5.p04;

class Source {
    static int minWeightedPath(final int[][] grid) {
        if(grid == null || grid.length==0) return 0;
        final int ROWLEN = grid.length;
        final int COLLEN = grid[0].length;
        final int[][] matrix = new int[ROWLEN][COLLEN];
        matrix[0][0] = grid[0][0];    
        for(int i=1; i<COLLEN; i++)
            matrix[0][i] = matrix[0][i-1] + grid[0][i];
        for(int j=1; j<ROWLEN; j++)
            matrix[j][0] = matrix[j-1][0] + grid[j][0];
        for(int i=1; i<ROWLEN; i++)
            for(int j=1; j<COLLEN; j++)
                if(matrix[i-1][j] > matrix[i][j-1])
                    matrix[i][j] = matrix[i][j-1] + grid[i][j];
                else matrix[i][j] = matrix[i-1][j] + grid[i][j];
        return matrix[ROWLEN-1][COLLEN-1];
    }
    /* ********************************************************************* */
    static int minWeightedPath2(final int[][] grid) {
        final int ROWLEN = grid.length;
        final int COLLEN = grid[0].length;
        final int[][] matrix = new int[ROWLEN+1][COLLEN+1];
        for (int i = 0; i < ROWLEN+1; i++)
            matrix[i][0] = Integer.MAX_VALUE/2;
        for (int j = 0; j < COLLEN+1; j++)
            matrix[0][j] = Integer.MAX_VALUE/2;
        matrix[1][0] = 0;
        matrix[0][1] = 0;
        for (int i = 1; i < ROWLEN+1; i++)
            for (int j = 1; j < COLLEN+1; j++) 
                matrix[i][j] = Math.min(matrix[i-1][j]+grid[i-1][j-1],
                        matrix[i][j-1]+grid[i-1][j-1]);
          
        return matrix[ROWLEN][COLLEN];
    }
    /* ********************************************************************* */
    static int minWeightedPath3(final int[][] grid) {return dfs(0,0,grid);}
    private static int dfs(final int I, final int J, final int[][] grid) {
        if(I == grid.length-1 && J == grid[0].length-1) return grid[I][J];
        if(I<grid.length-1 && J<grid[0].length-1) {
            int r1 = grid[I][J] + dfs(I+1, J, grid);
            int r2 = grid[I][J] + dfs(I, J+1, grid);
            return Math.min(r1, r2);
        }
        if(I<grid.length-1) return grid[I][J] + dfs(I+1, J, grid);
        if(J<grid[0].length-1) return grid[I][J] + dfs(I, J+1, grid);
        return 0;
    }
}
