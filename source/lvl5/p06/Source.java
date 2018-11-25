package source.lvl5.p06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

class Source {
    /* ********************************************************************* */
    ArrayList<String> boggleByot(final char[][] board, final ArrayList<String> dictionary) {
        final TreeSet<String> output = new TreeSet<>();
        final Trie trie = new Trie();
        for(String s : dictionary) trie.insertWord(s);
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                search(i, j, board, trie, "", output);
        return new ArrayList<>(output);
    }

    private void search(
            final int ROW,
            final int COL,
            final char[][] board,
            final Trie dictionary,
            String prefix,
            final TreeSet<String> output) {
        if(ROW > board.length-1 || ROW < 0 || COL > board[0].length-1 || COL < 0
                || !dictionary.hasPrefix(prefix) || board[ROW][COL] == '*') return;
        if(dictionary.hasWord(prefix)) output.add(prefix);
        final char c = board[ROW][COL];
        prefix += c;
        board[ROW][COL] = '*';
        search(ROW-1, COL, board, dictionary, prefix, output);
        search(ROW+1, COL, board, dictionary, prefix, output);
        search(ROW, COL-1, board, dictionary, prefix, output);
        search(ROW, COL+1, board, dictionary, prefix, output);
        board[ROW][COL] = c;
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
}
