package source.lvl4.p05;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
        if(root == null || root.left == nul && root.right == null)
            return root;
        //
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 2; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        tree.print();
        System.out.println(new Source().findLCA(tree.root, a, b).data);
    }
}
