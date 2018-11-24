package source.lvl3.p18;

import source.support.datastructure.node.TreeNode;

class Source {
    int numberOfHalfNodes(final TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        if(root.left == null && root.right != null || 
           root.right == null && root.left != null) count += 1;
        return numberOfHalfNodes(root.left) + numberOfHalfNodes(root.right) + count;
    }
}
