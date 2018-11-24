package source.lvl3.p14;

public class SourceMain {
     public static void main(String[] args) {
        final Source trie = new Source();
        final Source trie2 = new Source();
        final Source trie3 = new Source();
        for(int i = 2; i < args.length; i++) {
            trie.insertWord(args[i]);
            trie2.insertWord2(args[i]);
            trie3.insertWord3(args[i]);
        }
        System.out.println(trie.searchWord(args[0]));
        System.out.println(trie2.searchWord2(args[0]));
        System.out.println(trie3.searchWord3(args[0]));
        System.out.println(trie.searchPrefix(args[1]));
        System.out.println(trie2.searchPrefix2(args[1]));
        System.out.println(trie3.searchPrefix3(args[1]));
    }
}
