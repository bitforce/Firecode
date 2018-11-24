package source.lvl3.p20;

import source.support.datastructure.tree.BinarySearchTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinarySearchTree tree = new BinarySearchTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(new Source().findMaxItr(tree.root));
        System.out.println(new Source().findMaxItr2(tree.root));
        System.out.println(new Source().findMaxItr3(tree.root));
    }
}
