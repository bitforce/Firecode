package source.lvl4.p12;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for(int i = 2; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        final int N1 = Integer.parseInt(args[0]);
        final int N2 = Integer.parseInt(args[1]);
        System.out.println(new Source().getNodeDistance(tree.root, N1, N2));
        System.out.println(new Source().getNodeDistance2(tree.root, N1, N2));
        System.out.println(new Source().getNodeDistance3(tree.root, N1, N2));
    }
}
