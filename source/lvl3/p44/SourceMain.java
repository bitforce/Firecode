package source.lvl3.p44;

import source.support.datastructure.tree.BinarySearchTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinarySearchTree tree = new BinarySearchTree();
        for(int i = 2; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        Source obj = new Source();
        obj.printRange(tree.root, a, b);
        obj.printRange2(tree.root, a, b);
        System.out.println(obj.rangeList);
        System.out.println(obj.rangeList2);
    }
}
