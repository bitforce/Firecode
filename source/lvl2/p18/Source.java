package source.lvl2.p18;
import source.support.datastructure.tree.BinaryTree;
import source.support.datastructure.node.TreeNode;
class Source {
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
    /* ********************************************************************* */
    private static boolean validateBST2(TreeNode root) {
        return isBST2(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static boolean isBST2(TreeNode root, int high, int low) {
        if(root == null) return true;
        if(root.data <= low || root.data >= high)
            return false;
        if(root.left != null && !isBST2(root, root.data, low))
            return false;
        if(root.right != null && !isBST2(root, high, root.data))
            return false;
        return true;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(validateBST(tree.root));
        System.out.println(validateBST2(tree.root));
    }
}
