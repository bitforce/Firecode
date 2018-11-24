package source.lvl3.p40;

import source.support.datastructure.node.TreeNode;

class Source {
    TreeNode findMin(TreeNode root) {
        if(root == null) return null;
        while(root.left != null)
            root = root.left;
        return root;
    }
    /* ********************************************************************* */
    TreeNode findMin2(final TreeNode root) {
        if(root == null) return null;
        if(root.left == null) return root;
        return findMin2(root.left);
    }
    /* ********************************************************************* */
    TreeNode findMin3(final TreeNode root) {
        return root==null?null:root.left==null?root:findMin(root.left);
    }
}
