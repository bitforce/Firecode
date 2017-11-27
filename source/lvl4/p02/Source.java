package source.lvl4.p02;
import java.util.*;
class Source {
    /* ********************************************************************* */
    public static int makeChange(int[] coins, int amount) {
        if(amount == 0) return 1;
        int solutions = 0;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] > amount) continue;
            solutions += makeChange(Arrays.copyOfRange(coins, i, coins.length), amount-coins[i]);
        }
        return solutions;
    }
    /* ********************************************************************* */
     public static int makeChange2(int[] coins, int amount) {
         if(amount < 0 || coins.length == 0) return 0;
         int[] changes = new int[amount + 1];
         changes[0] = 1;
         for(int coin : coins)
             for(int change = coin; change < changes.length; change++)
                 changes[change] += changes[change-coin];
         return changes[amount];
     }
    /* ********************************************************************* */
    public static int makeChange3(int[] coins, int amount) {
        if (coins == null || amount < 0) return 0;
        int [][] cache = new int[coins.length + 1][amount + 1];
        for (int iter = 0; iter <= amount; iter++) cache[0][iter] = 0;
        for (int iter = 0; iter <= coins.length; iter++) cache[iter][0] = 1;
        for (int i = 1; i <= coins.length; i++)
            for (int j = 1; j <= amount; j++)
                cache[i][j] = cache[i - 1][j] + ((j < coins[coins.length - i]) ? 
                        0: cache[i][j - coins[coins.length - i]]);
        return cache[coins.length][amount];
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] coins = new int[args.length-1];
        for(int i = 0; i < coins.length; i++)
            coins[i] = Integer.parseInt(args[i]);
        final int N = Integer.parseInt(args[args.length-1]);
        System.out.println(makeChange(coins, N));
        System.out.println(makeChange2(coins, N));
        System.out.println(makeChange3(coins, N));
    }
}
