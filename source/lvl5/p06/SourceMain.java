package source.lvl5.p06;

import source.support.print.MatrixPrinter;

import java.util.ArrayList;
import java.util.Arrays;

public class SourceMain {
    public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        final char[][] board = new char[M][N];
        final int BOARD_LEN = M*N;
        final char[] temp = new char[BOARD_LEN];
        for(int i = 0; i < BOARD_LEN; i++)
            temp[i] = args[i+2].charAt(0);
        for(int i = 0; i < M; i++)
          System.arraycopy(temp, i*N, board[i], 0, N);
        MatrixPrinter.print(board);
        final ArrayList<String> dictionary =
                new ArrayList<>(Arrays.asList(args).subList(BOARD_LEN + 2, args.length));
        System.out.println(new Source().boggleByot(board, dictionary));
    }
}
