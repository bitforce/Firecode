package source.lvl4.p19;
import source.support.print.MatrixPrinter;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static int matrixMaxSumDfs(int[][] grid) {
        return matrixMaxSumDfs(grid, 0, 0) + grid[0][0];
    }
    private static int matrixMaxSumDfs(int[][] grid, int r, int c) {
        if(r+1 >= grid.length && c+1 >= grid[0].length) return 0;
        if(r+1 >= grid.length) return grid[r][c+1] + matrixMaxSumDfs(grid, r, c+1);
        if(c+1 >= grid[0].length) return grid[r+1][c] + matrixMaxSumDfs(grid, r+1, c);
        if(grid[r+1][c] > grid[r][c+1]) return grid[r+1][c] + matrixMaxSumDfs(grid, r+1, c);
        return grid[r][c+1] + matrixMaxSumDfs(grid, r, c+1);
    }
    /* ********************************************************************* */
    public static int matrixMaxSumDfs2(int[][] grid) {
        class TravelNode {
            int row;
            int col;
            int nodeSum;
            TravelNode(int r, int c, int sum, int[][] grid) {
                row = r;
                col = c;
                sum += grid[r][c];
                nodeSum = sum;
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows < 2 && cols < 2) return grid[0][0];
        else {
            Deque<TravelNode> stack = new LinkedList<>();
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
    private static int matrixMaxSumDfs3(int[][] grid) {return matrixMaxSumDfs3(grid, 0, 0);}
    private static int matrixMaxSumDfs3(int[][] grid, int r, int c) {
        if(r >= grid.length || c >= grid[0].length) return 0;
        return grid[r][c] + Math.max(matrixMaxSumDfs3(grid, r+1, c), matrixMaxSumDfs3(grid, r, c+1));
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
        System.out.println(matrixMaxSumDfs(matrix));
        System.out.println(matrixMaxSumDfs2(matrix));
        System.out.println(matrixMaxSumDfs3(matrix));
    }
}
