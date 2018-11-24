package source.lvl2.p03;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        final Source obj = new Source();
        tree.print();
        obj.preorder(tree.root);
        System.out.println(obj.preorderedList);
    }
}
