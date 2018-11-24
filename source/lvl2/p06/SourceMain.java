package source.lvl2.p06;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
         for (String arg : args) tree.add(Integer.parseInt(arg));
        System.out.println(new Source().sum(tree.root));
    }
}
