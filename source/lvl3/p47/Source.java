package source.lvl3.p47;

class Source {
    int countPaths(final int M, final int N) {
        if(M == 1 || N == 1) return 1;
        return countPaths(M-1, N) + countPaths(M, N-1);
    }
    /* ********************************************************************* */
    int countPaths2(int M, int N) {
        int count[][] = new int[M][N];
        for(int i = 0; i < M; i++) count[i][0] = 1;
        for(int i = 0; i < N; i++) count[0][i] = 1;
        for(int i = 1; i < M; i++)
            for(int j = 1; j < N; j++)
                count[i][j] = count[i-1][j] + count[i][j-1];
        return count[M-1][N-1];
    }
    /* ********************************************************************* */
    int countPaths3(int M, int N){
        if(M <= 0 || N <= 0) return 0;
        int min = Math.min(M,N) - 1;
        int max = Math.max(M,N) - 1;
        double prod = 1;
        for(int i = 0; i < min; i++)
            prod *= (min + max - i) / ((double) min - i);
        return (int)Math.round(prod);
    }
}
