package source.lvl4.p07;

import source.support.datastructure.node.TreeNode;

class Source {
    boolean isMirror(final TreeNode root1, final TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.data == root2.data
            && isMirror(root1.left, root2.right)
            && isMirror(root1.right, root2.left); 
    }
}
