package source.lvl4.p11;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
    public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for (String arg : args) tree.add(Integer.parseInt(arg));
        tree.print();
        System.out.println(new Source().levelorderRev(tree.root));
        System.out.println(new Source().levelorderRev2(tree.root));
        System.out.println(new Source().levelorderRev3(tree.root));
    }
}
