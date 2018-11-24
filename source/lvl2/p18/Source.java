package source.lvl2.p18;

import source.support.datastructure.node.TreeNode;

class Source {
    static boolean validateBST(TreeNode root) {
        return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private static boolean isBST(TreeNode root, int high, int low) {
        if(root == null) return true;
        if(root.data <= low || root.data >= high) return false;
        return isBST(root.left, root.data, low) && 
            isBST(root.right, high, root.data);
    }
    /* ********************************************************************* */
    static boolean validateBST2(TreeNode root) {
        return isBST2(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private static boolean isBST2(TreeNode root, int high, int low) {
        if(root == null) return true;
        if(root.data <= low || root.data >= high)
            return false;
        if(root.left != null && !isBST2(root, root.data, low))
            return false;
        return root.right == null || isBST2(root, high, root.data);
    }
}
