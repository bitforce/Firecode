/**
 * Validate Binary Search Tree.
 * Given the root node of a Binary Tree, determine if it is a 
 * Binary Search Tree.
 */
class ValidateBST {
    private static TreeNode root;
    private ValidateBST() {root = null;}
    /* ********************************************************************* */
    private static boolean validateBST(TreeNode root) {
        return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private static boolean isBST(TreeNode root, int high, int low) {
        if(root == null) return true;
        if(root.data <= low || root.data >= high) return false;
        return isBST(root.left, root.data, low) && 
            isBST(root.right, high, root.data);
    }
    private static boolean isBST2(TreeNode root, int high, int low) {
        if(root == null) return true;
        if(root.data <= low || root.data >= high)
            return false;
        if(root.left != null && !isBST(root, root.data, low))
            return false;
        if(root.right != null && !isBST(root, high, root.data))
            return false;
        return true;
    }
    /* ********************************************************************* */
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
    public static void main(String[] args) {
        ValidateBST tree = new ValidateBST();
        for(int i = 0; i < args.length; i++)
            tree.insert(Integer.parseInt(args[i]));
        System.out.println(validateBST(root));
        tree.print(root, 0);
    }
}
