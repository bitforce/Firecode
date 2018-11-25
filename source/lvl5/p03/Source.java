package source.lvl5.p03;

import java.util.ArrayList;

class Source {
    static ArrayList<ArrayList<Integer>> generatePascalTriangle(final int NUM_ROWS) {
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(NUM_ROWS <= 0) return result;
        ArrayList<Integer> levels = new ArrayList<>();
        levels.add(1);
        result.add(levels);
        for(int i = 2; i <= NUM_ROWS; i++) {
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
    static ArrayList<ArrayList<Integer>> generatePascalTriangle2(final int NUM_ROWS) {
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (NUM_ROWS == 0) return result;
        int[][] dp = new int[NUM_ROWS][NUM_ROWS];
        dp[0][0] = 1;
        for (int i = 1; i < NUM_ROWS; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0) dp[i][j] = 1;
                else if (j == i) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        for (int[] array : dp){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for (int anArray : array)
                if (anArray > 0) cur.add(anArray);
            result.add(cur);
        }
        return result;
    }
}
