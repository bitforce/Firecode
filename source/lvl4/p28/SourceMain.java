package source.lvl4.p28;

import source.support.print.MatrixPrinter;

import static source.lvl4.p28.Source.boggleSearch;

public class SourceMain {
    public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        final char[][] board = new char[M][N];
        int e = 3;
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = args[e++].charAt(0);
        MatrixPrinter.print(board);
        System.out.println(boggleSearch(board, args[2]));
    }
}
