package source.lvl3.p19;

import source.support.datastructure.tree.BinarySearchTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinarySearchTree tree = new BinarySearchTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        tree.root = new Source().mirror(tree.root);
        tree.print();
        tree.root = new Source().mirror2(tree.root);
        tree.print();
        tree.root = new Source().mirror3(tree.root);
    }
}
