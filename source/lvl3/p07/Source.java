package source.lvl3.p07;

import source.support.datastructure.node.TreeNode;

class Source {
    boolean isIdentical(final TreeNode root1, final TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 != null && root2 != null && root1.data == root2.data)
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        return false;
    }
    /* ********************************************************************* */
    boolean isIdentical2(final TreeNode root1, final TreeNode root2) {
        if(root1 == null && root2 == null)
           return true;
        if(root1 == null || root2 == null)
           return false;
        if(root1.data != root2.data)
            return false;
        return isIdentical( root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
}
