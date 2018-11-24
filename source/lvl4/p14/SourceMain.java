package source.lvl4.p14;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
    public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(new Source().findMaxSumLevel(tree.root));
        System.out.println(new Source().findMaxSumLevel2(tree.root));
        System.out.println(new Source().findMaxSumLevel3(tree.root));
    }
}
