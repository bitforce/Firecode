package source.support.datastructure.node;
import java.util.*;
public class TrieNode {
    public char c;
    public Boolean isLeaf = false;
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode() {}
    public TrieNode(Character c) {this.c = c;}
}
