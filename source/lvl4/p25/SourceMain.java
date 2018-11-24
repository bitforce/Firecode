package source.lvl4.p25;

import source.support.datastructure.tree.BinarySearchTree;

public class SourceMain {
    public static void main(String[] args) {
        final BinarySearchTree tree = new BinarySearchTree();
        for(int i = 1; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        new Source().delete(tree.root, Integer.parseInt(args[0]));
        tree.print();
        new Source().delete2(tree.root, Integer.parseInt(args[args.length-1]));
        tree.print();
    }
}
