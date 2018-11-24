package source.lvl4.p02;

import java.util.*;

class Source {
    static int makeChange(final int[] coins, final int AMOUNT) {
        if(AMOUNT == 0) return 1;
        int solutions = 0;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] > AMOUNT) continue;
            solutions += makeChange(Arrays.copyOfRange(coins, i, coins.length), AMOUNT-coins[i]);
        }
        return solutions;
    }
    /* ********************************************************************* */
    static int makeChange2(final int[] coins, final int AMOUNT) {
         if(AMOUNT < 0 || coins.length == 0) return 0;
         final int[] changes = new int[AMOUNT + 1];
         changes[0] = 1;
         for(int coin : coins)
             for(int change = coin; change < changes.length; change++)
                 changes[change] += changes[change-coin];
         return changes[AMOUNT];
     }
    /* ********************************************************************* */
    static int makeChange3(final int[] coins, final int AMOUNT) {
        if (coins == null || AMOUNT < 0) return 0;
        int [][] cache = new int[coins.length + 1][AMOUNT + 1];
        for (int iter = 0; iter <= AMOUNT; iter++) cache[0][iter] = 0;
        for (int iter = 0; iter <= coins.length; iter++) cache[iter][0] = 1;
        for (int i = 1; i <= coins.length; i++)
            for (int j = 1; j <= AMOUNT; j++)
                cache[i][j] = cache[i - 1][j] + ((j < coins[coins.length - i]) ? 
                        0: cache[i][j - coins[coins.length - i]]);
        return cache[coins.length][AMOUNT];
    }
}
