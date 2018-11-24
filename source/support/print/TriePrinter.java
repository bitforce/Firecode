package source.support.print;
import source.support.datastructure.node.TrieNode;
import java.util.ArrayList;
public class TriePrinter {
    public static void print(TrieNode root) {
        // print trie, then print words that trie makes
        System.out.println();
        for(String word : words(root)) {System.out.println(word);}
    }

    /* **************************************** */
    // ASSIST
    /* **************************************** */
    private static ArrayList<String> words(TrieNode root) {
        ArrayList<String> list = new ArrayList<>();
        // ...
        return list;
    }

    // methods for graphically rep of trie below
}
