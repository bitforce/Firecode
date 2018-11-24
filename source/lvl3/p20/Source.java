package source.lvl3.p20;
import source.support.datastructure.tree.BinarySearchTree;
import source.support.datastructure.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int findMaxItr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int max = root.data;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(max < node.data) max = node.data;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return max;
    }
    /* ********************************************************************* */
    private int findMaxItr2(TreeNode root) {                         
        int max = Integer.MIN_VALUE; 
        if(root != null) {
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            TreeNode curr = null;
            while(!q.isEmpty()) {
                curr = q.remove();
                if(max < curr.data) max = curr.data;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return max;
    }
    /* ********************************************************************* */
    private int findMaxItr3(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node == null) continue;
            max = Math.max(max, node.data);
            stack.push(node.left);
            stack.push(node.right);
        }
        return max;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().findMaxItr(tree.root));
        System.out.println(new Source().findMaxItr2(tree.root));
        System.out.println(new Source().findMaxItr3(tree.root));
    }
}
