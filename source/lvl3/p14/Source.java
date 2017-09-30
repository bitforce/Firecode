package source.lvl3.p14;
import source.temp.node.TrieNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private TrieNode root;
    private Source() {root = new TrieNode();}
    private void insertWord(String word) {
        if(word == null) return;
        HashMap<Character, TrieNode> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node;
            if(map.containsKey(c)) node = map.get(c);
            else {
                node = new TrieNode(c);
                map.put(c, node);
            }
            map = node.children;
            if(i == word.length()-1) node.isLeaf = true;
        }
    }
    private boolean searchWord(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isLeaf;
    }
    private boolean searchPrefix(String word) {
        return searchNode(word) != null;
    }
    private TrieNode searchNode(String word) {
        if(word == null) return null;
        Map<Character, TrieNode> map = root.children;
        TrieNode node = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(map.containsKey(c)) {
                node = map.get(c);
                map = node.children;
            } else return null;
        }
        return node;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        Source trie = new Source();
        for(int i = 2; i < args.length; i++)
            trie.insertWord(args[i]);
        System.out.println(trie.root.children.size());
        System.out.println(trie.searchWord(args[0]));
        System.out.println(trie.searchPrefix(args[1]));
    }
}
