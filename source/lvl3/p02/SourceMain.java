package source.lvl3.p02;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println();
        Source obj = new Source();
        System.out.println(obj.printLevelByLevel(tree.root));
        System.out.println(obj.printLevelByLevel2(tree.root));
    }
}
