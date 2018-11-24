package source.lvl3.p43;

import source.support.datastructure.node.TreeNode;

class Source {
    TreeNode insert(final TreeNode root, final int DATA) {
        if(root == null) return new TreeNode(DATA, null, null);
        if(root.data >= DATA) root.left = insert(root.left, DATA);
        if(root.data < DATA) root.right = insert(root.right, DATA);
        return root;
    }
    /* ********************************************************************* */
    TreeNode insert2(TreeNode root, final int DATA) {
        if(root == null) return new TreeNode(DATA, null, null);
        TreeNode node = root;
        while(true) {
            if(DATA <= node.data) {
                if(node.left != null) node = node.left;
                else {
                    node.left = new TreeNode(DATA, null, null);
                    return root;
                }
            } else {
                if(node.right != null) node = node.right;
                else {
                    node.right = new TreeNode(DATA, null, null);
                    return root;
                }
            }
        }
    }
}
