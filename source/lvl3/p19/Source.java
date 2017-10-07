package source.lvl3.p19;
import source.temp.tree.BinarySearchTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private TreeNode mirror(TreeNode root) {
        if(root == null) return null;
        mirror(root.left);
        mirror(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        return root; 
    }
    /* ********************************************************************* */
    private TreeNode mirror2(TreeNode root) {
        if(root == null) return null;
        TreeNode left = root.left;
        root.left = mirror2(root.right);
        root.right = mirror2(left);
        return root;
    }
    /* ********************************************************************* */
    private TreeNode mirror3(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> m = new LinkedList<TreeNode>();
        TreeNode node = new TreeNode(root.data, null, null);
        q.add(root);
        m.add(node);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            TreeNode curr = m.poll();
            if(temp == null || curr == null) continue;
            if(temp.left == null) curr.right = null;
            else curr.right = new TreeNode(temp.left.data, null, null);
            if(temp.right == null) curr.left = null;
            else curr.left = new TreeNode(temp.right.data, null, null);
            q.add(temp.right);
            q.add(temp.left);
            m.add(curr.left);
            m.add(curr.right);
        }
        return node;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        tree.root = new Source().mirror(tree.root);
        tree.print();
        tree.root = new Source().mirror2(tree.root);
        tree.print();
        tree.root = new Source().mirror3(tree.root);
    }
}
