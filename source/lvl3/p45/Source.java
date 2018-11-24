package source.lvl3.p45;

class Source {
    static int maxProfit(final int[] a) {
        if(a.length < 3) return 0;
        int profit = 0;
        for(int i = 0; i < a.length-1; i++)
            if(a[i] < a[i+1]) profit += a[i+1] - a[i];
        return profit;
    }
    /* ********************************************************************* */
    static int maxProfit2(final int[] prices){
        int profit = 0;
        for(int i=1; i < prices.length; i++)
            if((prices[i] - prices[i-1]) > 0)
                profit += prices[i] - prices[i-1];
        return profit > 0 ? profit : 0;
    }
}
