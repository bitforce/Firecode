package source.lvl3.p25;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(new Source().minTreeDepth(tree.root));
        System.out.println(new Source().minTreeDepth2(tree.root));
        System.out.println(new Source().minTreeDepth3(tree.root));
    }
}
