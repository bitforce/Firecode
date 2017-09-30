import temp.node.TrieNode;
import java.util.*;

class Source {
    /* ********************************************************************* */
    private TrieNode root;
    Source() {root = new TrieNode();}
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
        if(node != null && node.isLeaf) return true;
        return false;
    }
    private boolean searchPrefix(String word) {
        if(searchNode(word) != null) return true;
        return false;
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
        System.out.println(trie.searchWord(args[0]));
        System.out.println(trie.searchPrefix(args[1]));
    }
}
