package source.lvl4.p05;

import source.support.datastructure.node.TreeNode;

class Source {
    TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
        if(root == null) return null;
        if(root.data == a.data || root.data == b.data) return root;
        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
    /* ********************************************************************* */
    TreeNode findLCA2(final TreeNode root, final TreeNode a, final TreeNode b) {
        final TreeNode left, right;
        if(root == null || a == null || b == null) return null;
        if(root == a || root == b) return root;
        left = findLCA2(root.left, a, b);
        right = findLCA2(root.right, a, b);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
    /* ********************************************************************* */
    TreeNode findLCA3(final TreeNode root, final TreeNode a, final TreeNode b) {
        if(root == null || root == a || root == b) return root;
        final TreeNode left = findLCA3(root.left, a , b);
        final TreeNode right = findLCA3(root.right, a, b);
        if(right != null && left != null) return root;
        return right != null ? right : left;
    }
}
