package source.lvl3.p42;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(new Source().sumItr(tree.root));
        System.out.println(new Source().sumItr2(tree.root));
    }
}
