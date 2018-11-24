package source.lvl3.p40;

import source.support.datastructure.tree.BinarySearchTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinarySearchTree tree = new BinarySearchTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(new Source().findMin(tree.root).data);
        System.out.println(new Source().findMin2(tree.root).data);
        System.out.println(new Source().findMin3(tree.root).data);
    }
}
