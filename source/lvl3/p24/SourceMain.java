package source.lvl3.p24;

import source.support.datastructure.tree.BinarySearchTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinarySearchTree tree = new BinarySearchTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(new Source().findMax(tree.root).data);
        System.out.println(new Source().findMax2(tree.root).data);
        System.out.println(new Source().findMax3(tree.root).data);
    }
}
