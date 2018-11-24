package source.lvl3.p24;
import source.support.datastructure.tree.BinarySearchTree;
import source.support.datastructure.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private TreeNode findMax(TreeNode root) {
        if(root == null || root.right == null && root.left == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int max = root.data;
        TreeNode node = root;
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if(max < temp.data) {
                max = temp.data;
                node = temp;
            }
            if(temp.left != null) stack.push(temp.left);
            if(temp.right != null) stack.push(temp.right);
        }
        return node;
    }
    /* ********************************************************************* */
    private TreeNode findMax2(TreeNode root) {
        if(root == null) return null;
        if(root.right == null) return root;
        return findMax2(root.right);
    }
    /* ********************************************************************* */
    private TreeNode findMax3(TreeNode root) {
        if(root == null) return null;
        while(root.next != null) root = root.next;
        return root;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().findMax(tree.root).data); 
        System.out.println(new Source().findMax2(tree.root).data);
        System.out.println(new Source().findMax3(tree.root).data); 
    }
}
