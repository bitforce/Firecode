package source.lvl3.p07;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree t1 = new BinaryTree();
        final BinaryTree t2 = new BinaryTree();
        for(int i = 0; i < args.length/2; i++)
            t1.add(Integer.parseInt(args[i]));
        for(int i = args.length/2; i < args.length; i++)
            t2.add(Integer.parseInt(args[i]));
        final Source obj = new Source();
        t1.print();
        t2.print();
        System.out.println(obj.isIdentical(t1.root, t2.root));
        System.out.println(obj.isIdentical2(t1.root, t2.root));
    }
}
