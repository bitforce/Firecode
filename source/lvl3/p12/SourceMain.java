package source.lvl3.p12;

import source.support.datastructure.tree.BinaryTree;

import static source.lvl3.p12.Source.validateBSTItr;
import static source.lvl3.p12.Source.validateBSTItr2;
import static source.lvl3.p12.Source.validateBSTItr3;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(validateBSTItr(tree.root));
        System.out.println(validateBSTItr2(tree.root));
        System.out.println(validateBSTItr3(tree.root));
    }
}
