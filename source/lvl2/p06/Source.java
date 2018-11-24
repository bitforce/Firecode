package source.lvl2.p06;

import source.support.datastructure.node.TreeNode;

class Source {
    int sum(TreeNode root) {
        if(root == null) return 0;
        return sum(root.right) + sum(root.left) + root.data;
    }
}
