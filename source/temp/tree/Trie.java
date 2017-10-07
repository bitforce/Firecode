package source.temp.tree;
import source.temp.node.TrieNode;
import java.util.HashMap;
public class Trie {
    public TrieNode root;
    public Trie() {this.root = new TrieNode();}
    public void clear() {root = null;}
    public void add(String word) {
        if(word == null) return;
        HashMap<Character, TrieNode> map = root.children;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node;
            if(map.containsKey(c)) node = map.get(c);
            else {
                node = new TrieNode();
                map.put(c, node);
            }
            map = node.children;
            if(i == word.length()-1) node.isLeaf = true;
        }
    }
    public boolean word(String word) {
        TrieNode node = search(word);
        return node != null && node.isLeaf;
    }
    public boolean prefix(String word) {return search(word) != null;}
    public TrieNode search(String word) {
        if(word == null) return null;
        HashMap<Character, TrieNode> map = root.children;
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
    public void print() {}
}
