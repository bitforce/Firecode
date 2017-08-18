import java.util.*;

class BinaryTree {
    private static TreeNode root;
    private BinaryTree() {root = null;}
    /* ********************************************************************* */
    private ArrayList<Integer> preorderedList = new ArrayList<>();
    private void preorder(TreeNode root) {
        if(root == null) return;
        preorderedList.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.insert(Integer.parseInt(args[i]));
        System.out.println(tree.preorder(root))
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
