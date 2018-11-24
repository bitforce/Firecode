package source.lvl3.p04;

import source.support.datastructure.tree.BinarySearchTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinarySearchTree tree = new BinarySearchTree();
        for(int i = 1; i < args.length; i++)
           tree.add(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[0]);
        Source obj = new Source();
        tree.print();
        System.out.println(obj.findKthLargest(tree.root, N).data);
        System.out.println(obj.findKthLargest2(tree.root, N).data);
    }
}
