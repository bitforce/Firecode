package source.lvl3.p14;

import source.support.datastructure.node.TrieNode;

import java.util.HashMap;

class Source {
    /* ********************************************************************* */
    private TrieNode root = new TrieNode();
    void insertWord(final String word) {
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
    boolean searchWord(final String word) {
        final TrieNode node = searchNode(word);
        return node != null && node.isLeaf;
    }
    boolean searchPrefix(final String word) {
        return searchNode(word) != null;
    }
    private TrieNode searchNode(final String word) {
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
    /* ********************************************************************* */
    void insertWord2(final String word) {
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

    boolean searchWord2(final String word) {
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

    boolean searchPrefix2(final String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else return false;
        }
        return true;
    }
    /* ********************************************************************* */
    void insertWord3(final String word) {
        if (word != null && word.length() > 0)
            insertWord3(root, word, 0);
    }
    private void insertWord3(final TrieNode currentNode, final String word, final int index) {
        char c = word.charAt(index);
        TrieNode node = currentNode.children.getOrDefault(c, new TrieNode(c));
        currentNode.children.put(c, node);
        if (index == word.length() - 1) {
            node.isLeaf = true;
            return;
        }
        insertWord3(node, word, index + 1);
    }

    boolean searchWord3(final String word) {
        if (word != null && word.length() > 0)
            return search(root, word, 0, true);
        return false;
    }

    boolean searchPrefix3(final String word) {
        if (word != null && word.length() > 0)
            return search(root, word, 0, false);
        return false;
    }

    private boolean search(final TrieNode curr, final String word, final int index, boolean searching) {
        final char c = word.charAt(index);
        TrieNode node = curr.children.get(c);
        if (node == null) return false;
        if (index == word.length() - 1) {
            if (searching)
                return node.isLeaf;
            return true;
        }
        return search(node, word, index + 1, searching);
    }
}
