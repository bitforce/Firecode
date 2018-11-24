package source.lvl2.p18;

import source.support.datastructure.tree.BinaryTree;

import static source.lvl2.p18.Source.validateBST;
import static source.lvl2.p18.Source.validateBST2;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(validateBST(tree.root));
        System.out.println(validateBST2(tree.root));
    }
}
