import java.util.*;

/**
 * Find max element in a binary tree recursively.
 * The root will never be null.
 */
class BinaryTree {
    private static TreeNode root;
    private BinaryTree(){root = null;}
    /* ********************************************************************* */
    private int findMax(TreeNode root) {
        int max = root.data;
        if(root.left != null) max = Math.max(max, findMax(root.left));
        if(root.right != null) max = Math.max(max, findMax(root.right));
        return max;
    }
    private int findMax2(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int rootData = Integer.MIN_VALUE;
        int leftData = Integer.MIN_VALUE;
        int rightData = Integer.MIN_VALUE;
        if(root != null) {
            rootData = root.data;
            leftData = findMax2(root.left);
            rightData = findMax2(root.right);
            if(leftData > rightData) max = leftData;
            else max = rightData;
            if(max < rootData) max = rootData;
        }
        return max;
    }
    private int findMax3(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, 
                Math.max(findMax3(root.left), findMax3(root.right)));
    }
    private int findMax4(TreeNode root) {
        return root == null ? Integer.MIN_VALUE : 
            Math.max(root.data, 
                Math.max(findMax4(root.left), findMax4(root.right)));
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.insert(Integer.parseInt(args[i]));
        tree.print(root, 0);
        System.out.println();
        System.out.println(tree.findMax(root));
        System.out.println(tree.findMax2(root));
        System.out.println(tree.findMax3(root));
        System.out.println(tree.findMax4(root));
    }
    private TreeNode insert(int data) {return root = insert(data, root);}
    private TreeNode insert(int data, TreeNode node) {
        if(node == null) return node = new TreeNode(data, null, null);
        if (node.right == null) node.right = insert(data, node.right);
        else node.left = insert(data, node.left);
        return node;
    }
    private void print(TreeNode root, int level) {
        if(root == null) return;
        print(root.right, level+1);
        if(level != 0) {
            for(int i = 0; i < level-1; i++)
                System.out.print("|\t");
            System.out.println("|----"+root.data);
        } else System.out.println(root.data);
        print(root.left, level+1);
    }
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }    
    }
}
