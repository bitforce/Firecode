package source.lvl4.p17;

import source.support.datastructure.tree.Trie;
import source.support.print.MatrixPrinter;

import java.util.Scanner;

public class SourceMain {
    public static void main(String[] args) {
        final Trie dict = new Trie();
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        final char[][] board = new char[M][N];
        int e = 2;
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = args[e++].charAt(0);
        for(int i = M*N+2; i < args.length; i++)
           dict.add(args[i]);
        MatrixPrinter.print(board);
        Scanner in = new Scanner(System.in);
        System.out.print("\nHow many words will the Trie contain? ");
        final int SENTINEL = in.nextInt();
        for(int i = 0; i < SENTINEL; i++) {
            System.out.print("Enter word: ");
            dict.add(in.next());
        }
        System.out.println();
        in.close();
        dict.print();
        System.out.println();
        System.out.println(new Source().boggleSearchWithDict(board, dict));
        System.out.println(new Source().boggleSearchWithDict2(board, dict));
        System.out.println(new Source().boggleSearchWithDict3(board, dict));
    }
}
