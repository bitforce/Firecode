package source.lvl3.p26;
import source.support.datastructure.tree.BinaryTree;
import source.support.datastructure.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private TreeNode findDeepest(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode node = root;
        while(!q.isEmpty()) {
            node = q.poll();
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return node;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().findDeepest(tree.root).data);
    }
}
