package source.lvl4.p02;

import static source.lvl4.p02.Source.makeChange;
import static source.lvl4.p02.Source.makeChange2;
import static source.lvl4.p02.Source.makeChange3;

public class SourceMain {
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
