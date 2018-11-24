package source.lvl3.p15;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(tree.root);
        final BinaryTree copy = new BinaryTree();
        copy.root = new Source().restoreTree(new Source().serializeTree(tree.root));
        copy.print();
        System.out.println(copy.root);
        final BinaryTree copy2 = new BinaryTree();
        copy2.root = new Source().restoreTree2(new Source().serializeTree2(tree.root));
        copy2.print();
        System.out.println(copy2.root);
    }
}
