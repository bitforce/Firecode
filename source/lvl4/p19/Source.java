package source.lvl4.p19;

import java.util.Deque;
import java.util.LinkedList;

class Source {
    static int matrixMaxSumDfs(final int[][] grid) {
        return matrixMaxSumDfs(grid, 0, 0) + grid[0][0];
    }
    private static int matrixMaxSumDfs(final int[][] grid, final int r, final int c) {
        if(r+1 >= grid.length && c+1 >= grid[0].length) return 0;
        if(r+1 >= grid.length) return grid[r][c+1] + matrixMaxSumDfs(grid, r, c+1);
        if(c+1 >= grid[0].length) return grid[r+1][c] + matrixMaxSumDfs(grid, r+1, c);
        if(grid[r+1][c] > grid[r][c+1]) return grid[r+1][c] + matrixMaxSumDfs(grid, r+1, c);
        return grid[r][c+1] + matrixMaxSumDfs(grid, r, c+1);
    }
    /* ********************************************************************* */
    static int matrixMaxSumDfs2(final int[][] grid) {
        class TravelNode {
            private int row;
            private int col;
            private int nodeSum;
            private TravelNode(int r, int c, int sum, int[][] grid) {
                row = r;
                col = c;
                sum += grid[r][c];
                nodeSum = sum;
            }
        }
        int maxSum = Integer.MIN_VALUE;
        final int rows = grid.length;
        final int cols = grid[0].length;
        if(rows < 2 && cols < 2) return grid[0][0];
        else {
            final Deque<TravelNode> stack = new LinkedList<>();
            stack.addFirst(new TravelNode(0,0,0,grid));
            while(!stack.isEmpty()){
                TravelNode t = stack.removeFirst();
                if(t.row == rows-1 && t.col == cols - 1) {
                    if(t.nodeSum > maxSum) maxSum = t.nodeSum;
                } else {
                    if(t.col < cols-1)
                        stack.addFirst(new TravelNode(t.row, t.col+1, t.nodeSum, grid));
                    if(t.row < rows-1)
                        stack.addFirst(new TravelNode(t.row + 1, t.col, t.nodeSum, grid));
                }
            }
        }
        return maxSum;
    }
    /* ********************************************************************* */
    static int matrixMaxSumDfs3(final int[][] grid) {return matrixMaxSumDfs3(grid, 0, 0);}
    private static int matrixMaxSumDfs3(final int[][] grid, final int r, final int c) {
        if(r >= grid.length || c >= grid[0].length) return 0;
        return grid[r][c] + Math.max(matrixMaxSumDfs3(grid, r+1, c), matrixMaxSumDfs3(grid, r, c+1));
    }
}
