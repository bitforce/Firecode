package source.lvl3.p36;

import source.support.datastructure.tree.BinarySearchTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinarySearchTree tree = new BinarySearchTree();
        final int k = Integer.parseInt(args[0]);
        for(int i = 1; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().findKthSmallest(tree.root, k).data);
        System.out.println(new Source().findKthSmallest2(tree.root, k).data);
    }
}
