package source.lvl4.p07;

import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
    public static void main(String[] args) {
        final BinaryTree t1 = new BinaryTree();
        final BinaryTree t2 = new BinaryTree();
        final BinaryTree t3 = new BinaryTree();
        for (String arg : args) {
            int data = Integer.parseInt(arg);
            t1.add(data);
            t2.add(data);
        }
        t1.print();
        t2.print();
        t3.print();
        final Source obj = new Source();
        System.out.println(obj.isMirror(t1.root, t2.root));
        System.out.println(obj.isMirror(t1.root, t3.root));
        System.out.println(obj.isMirror(t3.root, null));
    }
}
