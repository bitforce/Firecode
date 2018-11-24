package source.lvl4.p17;

import source.support.print.MatrixPrinter;
import source.support.datastructure.tree.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

class Source {
    /** GIVEN SOLUTION : FAILED */
    ArrayList<String> boggleSearchWithDict(final char[][] board, final Trie dict) {
        final TreeSet<String> ts = new TreeSet<>();
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[0].length; c++)
                build(board, dict, ts, board[r][c]+"", r, c);
        return new ArrayList<>(ts);
    }
    private void build(
            final char[][] board,
            final Trie dict,
            final TreeSet<String> ts,
            final String prefix,
            final int r,
            final int c) {
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
    ArrayList<String> boggleSearchWithDict2(final char[][] board, final Trie dictionary){
        final TreeSet<String> words = new TreeSet<>();
        for(int r=0; r<board.length; r++)
            for(int c=0; c<board.length; c++) {
                TreeSet<String> temp = new TreeSet<>();
                build2(board, dictionary, r, c, "", new HashSet<Integer>(), temp);
                words.addAll(temp);
            }
        return new ArrayList<>(words);
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
    ArrayList<String> boggleSearchWithDict3(final char[][] board, final Trie dictionary){
        HashSet<String> output = new HashSet<>();
        final int rows = board.length;
        final int cols = board[0].length;
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                build3(board, dictionary, r, c, "", output);
        ArrayList<String> list = new ArrayList<String>(output);
        Collections.sort(list);
        return list;
    }

    private void build3(
            final char[][] board,
            final Trie dictionary,
            final int r,
            final int c,
            String word,
            final HashSet<String> output) {
        int rows = board.length;
        int cols = board[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (board[r][c] == '.') return;
        word += board[r][c];
        final char OLD = board[r][c];
        board[r][c] = '.';
        if (dictionary.word(word)) output.add(word);
        if (dictionary.prefix(word)) {
            build3(board, dictionary, r + 1, c, word, output);
            build3(board, dictionary, r - 1, c, word, output);
            build3(board, dictionary, r, c + 1, word, output);
            build3(board, dictionary, r, c - 1, word, output);
        }
        
        board[r][c] = OLD;
    }
}
