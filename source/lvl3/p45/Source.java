package source.lvl3.p45;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static int maxProfit(int[] a) {
        if(a.length < 3) return 0;
        int profit = 0;
        for(int i = 0; i < a.length-1; i++)
            if(a[i] < a[i+1]) profit += a[i+1] - a[i];
        return profit;
    }
    /* ********************************************************************* */
    private static int maxProfit2(int[] prices){
        int profit = 0;
        for(int i=1; i < prices.length; i++)
            if((prices[i] - prices[i-1]) > 0)
                profit += prices[i] - prices[i-1];
        return profit > 0 ? profit : 0;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] a = new int[args.length];
        for(int i = 0; i < args.length; i++)
            a[i] = Integer.parseInt(args[i]);
        System.out.println(maxProfit(a));
        System.out.println(maxProfit2(a));
    }
}
