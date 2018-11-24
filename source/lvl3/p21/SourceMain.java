package source.lvl3.p21;

import source.support.datastructure.tree.BinarySearchTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinarySearchTree tree = new BinarySearchTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(new Source().numberOfFullNodes(tree.root));
        System.out.println(new Source().numberOfFullNodes2(tree.root));
        System.out.println(new Source().numberOfFullNodes3(tree.root));
    }
}
