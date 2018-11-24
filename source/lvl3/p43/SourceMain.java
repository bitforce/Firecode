package source.lvl3.p43;

import source.support.datastructure.tree.BinarySearchTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinarySearchTree tree = new BinarySearchTree();
        for(int i = 1; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        final int DATA = Integer.parseInt(args[0]);
        tree.root = new Source().insert(tree.root, DATA);
        tree.root = new Source().insert2(tree.root, DATA+1);
        tree.print();
    }
}
