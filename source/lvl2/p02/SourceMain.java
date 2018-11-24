package source.lvl2.p02;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        Source obj = new Source();
        tree.print();
        System.out.println();
        System.out.println(obj.findMax(tree.root));
        System.out.println(obj.findMax2(tree.root));
        System.out.println(obj.findMax3(tree.root));
        System.out.println(obj.findMax4(tree.root));
    }
}
