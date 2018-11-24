package source.lvl2.p05;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
         for (String arg : args) tree.add(Integer.parseInt(arg));
        System.out.println(new Source().size(tree.root));
    }
}
