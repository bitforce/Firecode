class BinaryTree {
    private static TreeNode root1, root2;
    private BinaryTree() {
        root1 = null;
        root2 = null;
    }
    /* ********************************************************************* */
    private boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 != null && root2 != null && root1.data == root2.data)
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        return false;
    } // BEST SOLUTION
    private boolean isIdentical2(TreeNode root1, TreeNode root2) {
        if ( root1 == null && root2 == null)
            return true;
        if ( root1 == null || root2 == null)
            return false;
        if ( root1.data != root2.data)
            return false;
        return isIdentical( root1.left, root2.left) && isIdentical( root1.right, root2.right);
    }
    /* ********************************************************************* */
    private TreeNode insert(int data, int n) {
        if(n == 1)
            return root1 = insert(data, root1);
        return root2 = insert(data, root2);
    }
    private TreeNode insert(int data, TreeNode node) {
        if(node == null) return node = new TreeNode(data, null, null);
        if (node.right == null) node.right = insert(data, node.right);
        else node.left = insert(data, node.left);
        return node;
    }
    private void print(int n) {
        if(n == 1)
            print(root1, 0);
        else
            print(root2, 0);
    }
    private void print(int n, String s) {
        if(n == 1)
            print(root1, 0);
        else
            print(root2, 0);
        System.out.print(s); 
    }
    private void print(TreeNode root, int level) {
        if(root == null) return;
        print(root.right, level+1);
        if(level != 0) {
            for(int i = 0; i < level-1; i++)
                System.out.print("|\t");
            System.out.println("|----{"+root.data);
        } else System.out.println(root.data);
        print(root.left, level+1);
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BinaryTree tree1 = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();
        for(int i = 0; i < args.length/2; i++)
            tree1.insert(Integer.parseInt(args[i]), 1);
        for(int i = args.length/2; i < args.length; i++)
            tree2.insert(Integer.parseInt(args[i]), 2);
        tree1.print(1, "\n");
        tree2.print(2, "\n");
        System.out.println(tree.isIdentical(tree1.root1, tree2.root2));
        System.out.println(tree.isIdentical2(tree1.root1, tree2.root2));
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
