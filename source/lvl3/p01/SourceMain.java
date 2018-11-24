package source.lvl3.p01;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for(int i = 1; i < args.length; i++)
           tree.add(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[0]);
        tree.print();
        System.out.println();
        final Source obj = new Source();
        System.out.println(obj.printAncestors(tree.root, N));
        System.out.println(obj.ancestorsList);
        System.out.println(obj.printAncestors2(tree.root, N));
        System.out.println(obj.ancestorsList2);
    }
}
