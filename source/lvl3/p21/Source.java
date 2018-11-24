package source.lvl3.p21;
import source.support.datastructure.tree.BinarySearchTree;
import source.support.datastructure.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int numberOfFullNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        if(root.left != null && root.right != null) count += 1;
        return numberOfFullNodes(root.left) + numberOfFullNodes(root.right) + count;
    }
    /* ********************************************************************* */
    private int numberOfFullNodes2(TreeNode root) {
    if(root == null) return 0;
        return numberOfFullNodes(root.left) +
               numberOfFullNodes(root.right) +
               (root.left!=null&&root.right!=null ? 1 : 0);
    }
    /* ********************************************************************* */
    private int numberOfFullNodes3(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        TreeNode node = null;
        while(!q.isEmpty()) {
            node = q.remove();
            if(node.left != null && node.right != null) count++;
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return count;
    }
    /* ********************************************************************* */

    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().numberOfFullNodes(tree.root));
        System.out.println(new Source().numberOfFullNodes2(tree.root));
        System.out.println(new Source().numberOfFullNodes3(tree.root));
    }
}
