package source.lvl5.p03;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static ArrayList<ArrayList<Integer>> generatePascalTriangle(int numRows) {
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(numRows <= 0) return result;
        ArrayList<Integer> levels = new ArrayList<>();
        levels.add(1);
        result.add(levels);
        for(int i = 2; i <= numRows; i++) {
            final ArrayList<Integer> current = new ArrayList<>();
            current.add(1);
            for(int j = 0; j < levels.size()-1; j++)
                current.add(levels.get(j) + levels.get(j+1));
            current.add(1);
            result.add(current);
            levels = current;
        }
        return result;
    }
    /* ********************************************************************* */
    private static ArrayList<ArrayList<Integer>> generatePascalTriangle2(int numRows) {
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        
        for (int i = 1; i < numRows; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0) dp[i][j] = 1;
                else if (j == i) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        
        for (int[] array : dp){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for (int i = 0; i < array.length; i++){
                if (array[i] > 0) cur.add(array[i]);
            }
            result.add(cur);
        }
        return result;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int ROWS = Integer.parseInt(args[0]);
        System.out.println(generatePascalTriangle(ROWS));
        System.out.println(generatePascalTriangle2(ROWS));
    }
}
