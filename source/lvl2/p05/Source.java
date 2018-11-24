package source.lvl2.p05;

import source.support.datastructure.node.TreeNode;

class Source {
    int size(TreeNode root) {
        if(root == null) return 0;
        return size(root.right) + size(root.left) + 1;
    }
}
