package source.lvl3.p46;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < args.length; i++)
            if(i != args.length-1) str.append(args[i]).append(",");
            else str.append(args[i]);
        tree.root = new Source().decompressTree(str.toString());
        tree.print();
        tree.root = new Source().decompressTree2(str.toString());
        tree.print();
        tree.root = new Source().decompressTree3(str.toString());
        tree.print();
    }
}
