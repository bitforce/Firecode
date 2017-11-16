package source.lvl3.p47;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int countPaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        return countPaths(m-1, n) + countPaths(m, n-1);
    }
    /* ********************************************************************* */
    private int countPaths2(int m, int n) {
        int count[][] = new int[m][n];
        for(int i = 0; i < m; i++) count[i][0] = 1;
        for(int i = 0; i < n; i++) count[0][i] = 1;
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                count[i][j] = count[i-1][j] + count[i][j-1];
        return count[m-1][n-1];
    }
    /* ********************************************************************* */
    public int countPaths3(int m, int n){
        if(m <= 0 || n <= 0) return 0;
        int min = Math.min(m,n) - 1;
        int max = Math.max(m,n) - 1;
        double prod = 1;
        for(int i = 0; i < min; i++)
            prod *= (min + max - i) / ((double) min - i);
        return (int)Math.round(prod);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        System.out.println(new Source().countPaths(M, N));
        System.out.println(new Source().countPaths2(M, N));
        System.out.println(new Source().countPaths3(M, N));
    }
}
