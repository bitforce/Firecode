package source.lvl4.p05;

import source.support.datastructure.node.TreeNode;
import source.support.datastructure.tree.BinaryTree;

public class SourceMain {
    public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        for(int i = 2; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        final Source obj = new Source();
        tree.print();
        System.out.println(obj.findLCA(tree.root, new TreeNode(a),
                           new TreeNode(b)).data);
        System.out.println(obj.findLCA2(tree.root, new TreeNode(a),
                           new TreeNode(b)).data);
        System.out.println(obj.findLCA3(tree.root, new TreeNode(a),
                           new TreeNode(b)).data);
    }
}
