package source.lvl3.p45;

import static source.lvl3.p45.Source.maxProfit;
import static source.lvl3.p45.Source.maxProfit2;

public class SourceMain {
     public static void main(String[] args) {
        int[] a = new int[args.length];
        for(int i = 0; i < args.length; i++)
            a[i] = Integer.parseInt(args[i]);
        System.out.println(maxProfit(a));
        System.out.println(maxProfit2(a));
    }
}
