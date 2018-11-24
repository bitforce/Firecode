package source.lvl3.p28;

import source.support.datastructure.tree.BinaryTree;

import static source.lvl3.p28.Source.maxSumPath;

public class SourceMain {
    public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(maxSumPath(tree.root));
    }
}
