package source.lvl5.p06;
import source.temp.help.MatrixPrinter;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private ArrayList<String> boggleByot(final char[][] board, final ArrayList<String> dictionary) { 
        final TreeSet<String> output = new TreeSet<>();
        final Trie trie = new Trie();
        for(String s : dictionary) trie.insertWord(s);
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                search(i, j, board, trie, "", output);
        return new ArrayList<>(output);
    }

    private void search(final int row, final int col, final char[][] board, final Trie dictionary,  String prefix, final TreeSet<String> output) {
        if(row > board.length-1 || row < 0 || col > board[0].length-1 || col < 0 
                || !dictionary.hasPrefix(prefix) || board[row][col] == '*') return;
        if(dictionary.hasWord(prefix)) output.add(prefix);
        final char c = board[row][col];
        prefix += c;
        board[row][col] = '*';
        search(row-1, col, board, dictionary, prefix, output);
        search(row+1, col, board, dictionary, prefix, output);
        search(row, col-1, board, dictionary, prefix, output);
        search(row, col+1, board, dictionary, prefix, output);
        board[row][col] = c;
    }
    
    private class Trie {
        private TrieNode root;
        Trie() {root = new TrieNode();}
        void insertWord(final String word) {
            TrieNode cur = root;
            HashMap<Character, TrieNode> children = cur.children;
            for(int i=0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(children.containsKey(c)) cur = children.get(c);
                else {
                    final TrieNode n = new TrieNode(c);
                    children.put(c,n);
                    cur = n;
                }
                children = cur.children;
                if(i == word.length()-1) cur.isLeaf = true;
            }
        }
        boolean hasWord(final String word) {
            TrieNode cur = root;
            HashMap<Character, TrieNode> children = cur.children;
            for(int i=0; i < word.length(); i++){
                final char c = word.charAt(i);
                if(children.containsKey(c)){
                    cur = children.get(c);
                    children = cur.children;
                } else return false;
            }
            return cur.isLeaf;
        }
        boolean hasPrefix(final String prefix) {
            TrieNode cur = root;
            HashMap<Character, TrieNode> children = cur.children;
            for (int i = 0; i < prefix.length(); i++) {
                final char c = prefix.charAt(i);
                if (children.containsKey(c)) {
                    cur = children.get(c);
                    children = cur.children;
                } else return false;
            }
            return true;
        }
    }
    private class TrieNode {
        char c;
        boolean isLeaf = false;
        final HashMap<Character, TrieNode> children = new HashMap<>();
        TrieNode(){}
        TrieNode(char c) {this.c = c;}
    }
    /* ********************************************************************* */
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
        final ArrayList<String> dictionary = new ArrayList<>();
        for(int i = BOARD_LEN+2; i < args.length; i++)
            dictionary.add(args[i]);
        System.out.println(new Source().boggleByot(board, dictionary));
    }
}
