package source.lvl2.p29;

import source.support.datastructure.node.TreeNode;

class Source {
    int numberOfLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return numberOfLeaves(root.left) + numberOfLeaves(root.right);
    }
}
