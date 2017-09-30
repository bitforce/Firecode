package temp.node;
import java.util.*;
public class TrieNode {
    public Character c;
    public Boolean isLeaf = false;
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode() {}
    public TrieNode(Character c) {this.c = c;}
}
