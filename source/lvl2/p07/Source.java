package source.lvl2.p07;

import source.support.datastructure.node.TreeNode;

class Source {
    int findHeight(TreeNode root) {
        if(root == null) return 0;
        return findHeight(root.left) + 1;
    }
}
