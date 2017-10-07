package source.lvl3.p14;
import source.temp.node.TrieNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private TrieNode root;
    private Source() {this.root = new TrieNode();}
    private void insertWord(String word) {
        if(word == null) return;
        HashMap<Character, TrieNode> map = root.children;
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
    public void insertWord2(String word) {
        if(word == null || word.length() < 1) return;
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
            } else {
                TrieNode n = new TrieNode(c);
                children.put(c, n);
                cur = n;
            }
            children = cur.children;

            if (i == word.length() - 1) {
                cur.isLeaf = true;
            }
        }
    }

    public boolean searchWord2(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else {
                return false;
            }
        }
        return cur.isLeaf;
    }

    public boolean searchPrefix2(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else {
                return false;
            }
        }
        return true;
    }
    /* ********************************************************************* */
    public void insertWord3(String word) {
        if (word != null && word.length() > 0) {
            insertWord3(root, word, 0);
        }
    }

    private void insertWord3(TrieNode currentNode, String word, int index) {
        char c = word.charAt(index);
        TrieNode node = currentNode.children.getOrDefault(c, new TrieNode(c));
        currentNode.children.put(c, node);
        if (index == word.length() - 1) {
            node.isLeaf = true;
            return;
        }
        insertWord3(node, word, index + 1);
    }

    public boolean searchWord3(String word) {
        if (word != null && word.length() > 0)
            return search(root, word, 0, true);
        return false;
    }

    public boolean searchPrefix3(String word) {
        if (word != null && word.length() > 0)
            return search(root, word, 0, false);
        return false;
    }

    private boolean search(TrieNode curr, String word, int index, boolean searching) {
        char c = word.charAt(index);
        TrieNode node = curr.children.get(c);
        if (node == null) {
            return false;
        }

        if (index == word.length() - 1) {
            if (searching) {
                return node.isLeaf;
            }
            return true;
        }

        return search(node, word, index + 1, searching);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        Source trie = new Source();
        for(int i = 2; i < args.length; i++)
            trie.insertWord(args[i]);
        System.out.println(trie.searchWord(args[0]));
        System.out.println(trie.searchWord2(args[0]));
        System.out.println(trie.searchWord3(args[0]));
        System.out.println(trie.searchPrefix(args[1]));
        System.out.println(trie.searchPrefix2(args[1]));
        System.out.println(trie.searchPrefix3(args[1]));
    }
}
