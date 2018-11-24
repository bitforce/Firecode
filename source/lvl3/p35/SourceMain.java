package source.lvl3.p35;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
     public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for(int i = 1; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        final int N = Integer.parseInt(args[0]);
        System.out.println(new Source().pathLengthFromRoot(tree.root, N));
        System.out.println(new Source().pathLengthFromRoot2(tree.root, N));
    }
}
