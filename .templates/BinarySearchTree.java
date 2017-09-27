import java.util.*;
class BST {
    private static TreeNode root;

    private BST() {root = null;}
    
    /* NOTE THIS METHOD ORDERS THE INPUT UNLIKE A REGULAR BINARY TREE */
    private TreeNode insert(int data) {return root = insert(data, root);}
    private TreeNode insert(int data, TreeNode root) {
        if (root == null) return new TreeNode(data);
        if (data <= root.data) root.left = insert(data, root.left);
        if (data > root.data) root.right = insert(data, root.right);
        return root;
    }

    private TreeNode search(int data) {return search(data, root);}
    private TreeNode search(int data, TreeNode root) {
        if (root == null || root.data == data) return root;
        if (root.data > data) return search(data, root.left);
        return search(data, root.right);
    }

    private void print() {print(0, root);}
    private void print(int level, TreeNode root) {
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
       for (int i = 0; i < args.length; i++)
           tree.insert(Integer.parseInt(args[i]));
       tree.print();
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
