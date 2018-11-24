package source.lvl4.p17;
import source.support.print.MatrixPrinter;
import source.support.datastructure.tree.Trie;
import java.util.*;
class Source {
    /* ********************************************************************* */
    /** GIVEN SOLUTION : FAILED */
    private ArrayList<String> boggleSearchWithDict(char[][] board, Trie dict) {
        TreeSet<String> ts = new TreeSet<>();
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[0].length; c++)
                build(board, dict, ts, board[r][c]+"", r, c);
        return new ArrayList<>(ts);
    }
    private void build(char[][] board, Trie dict, TreeSet<String> ts, String prefix, int r, int c) {
        System.out.println(r + " " + c);
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length 
                 || !dict.prefix(prefix) || board[r][c] == '@') return;
        System.out.println("PASS " + r + " " + c + prefix);
        char temp = board[r][c];
        String s = prefix + temp;
        if(dict.word(s)) ts.add(s);
        board[r][c] = '@';
        build(board, dict, ts, s, r+1, c);
        build(board, dict, ts, s, r-1, c);
        build(board, dict, ts, s, r, c+1);
        build(board, dict, ts, s, r, c-1);
        board[r][c] = temp;
    } 
    /* ********************************************************************* */
    private ArrayList<String> boggleSearchWithDict2(char[][] board, Trie dictionary){
        TreeSet<String> words = new TreeSet<>();
        for(int r=0; r<board.length; r++)
            for(int c=0; c<board.length; c++) {
                TreeSet<String> temp = new TreeSet<>();
                build2(board, dictionary, r, c, "", new HashSet<Integer>(), temp);
                words.addAll(temp);
            }
        return new ArrayList<String>(words);
    }
    private void build2(char[][] board, Trie dictionary, int row, int col, String str, 
                        HashSet<Integer> set, TreeSet<String> words) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        str = str + board[row][col];
        if(!dictionary.prefix(str)) return;
        if(dictionary.word(str)) words.add(str);
        for(int i = 0; i < 4; i++) {
            int r = row + ((1-(i%2)) * (i-1));
            int c = col + ((i%2)* (i-2));
            HashSet<Integer> copy = new HashSet<>(set);
            int hash = r + c * Math.max(board.length, board[0].length);
            if(copy.add(hash)) build2(board, dictionary, r, c, str, copy, words);
        }
    }
    /* ********************************************************************* */
    private ArrayList<String> boggleSearchWithDict3(char[][] board, Trie dictionary){
        Set<String> output = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                build3(board, dictionary, r, c, "", output);
        ArrayList<String> list = new ArrayList<String>(output);
        Collections.sort(list);
        return list;
    }

    private void build3(char[][] board, Trie dictionary, int r, int c, String word, Set<String> output) {
        int rows = board.length;
        int cols = board[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (board[r][c] == '.') return;
        word += board[r][c];
        char old = board[r][c];
        board[r][c] = '.';
        if (dictionary.word(word)) output.add(word);
        if (dictionary.prefix(word)) {
            build3(board, dictionary, r + 1, c, word, output);
            build3(board, dictionary, r - 1, c, word, output);
            build3(board, dictionary, r, c + 1, word, output);
            build3(board, dictionary, r, c - 1, word, output);
        }
        
        board[r][c] = old;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        Trie dict = new Trie();
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        char[][] board = new char[M][N];
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
