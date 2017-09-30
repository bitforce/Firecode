import java.util.*;
class BST {
    private static TreeNode root;
    private BST() {root = null;}
    /* ********************************************************************* */
    private int counter;
    private TreeNode findKthLargest(TreeNode root, int k) {
        if (root == null) return null;
        TreeNode node = findKthLargest(root.right, k);
        if (counter != k) {
            node = root;
            counter++;
        }
        if (counter == k) return node;
        return findKthLargest(root.left, k);
    }
    private TreeNode findKthLargest2(TreeNode root, int k) { // BEST SOLUTION
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) 
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                if (k-- == 1) break;
                node = node.left;
            }
        return node;
    }
    /* ********************************************************************* */
    private void insert(int data) {root = insert(data, root);}
    private TreeNode insert(int data, TreeNode root) {
        if (root == null) return new TreeNode(data);
        if (data <= root.data) root.left = insert(data, root.left);
        if (data > root.data) root.right = insert(data, root.right);
        return root;
    }
    private void print() {print(root, 0);}
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
    public static void main(String[] args) {
        BST tree = new BST();
        for(int i = 0; i < args.length-1; i++)
           tree.insert(Integer.parseInt(args[i+1]));
        tree.print();
        System.out.println("\n" + tree.findKthLargest(root, Integer.parseInt(args[0])).data);
        System.out.println(tree.findKthLargest2(root, Integer.parseInt(args[0])).data);
    }
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {this.data = data;}
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
