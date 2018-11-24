package source.lvl3.p36;

import source.support.datastructure.node.TreeNode;

import java.util.Stack;

class Source {
    int count = 0;
    TreeNode findKthSmallest(final TreeNode root, final int k) {
        if(root == null || k < 1) return null;
        TreeNode node = findKthSmallest(root.left, k);
        if(count != k) {
            node = root;
            count++;
        }
        if(count == k) return node;
        return findKthSmallest(node.right, k);
    }
    /* ********************************************************************* */
    TreeNode findKthSmallest2(TreeNode root, int k) {
        if(root == null) return null;
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node == null) {
                node = stack.pop();
                if(--k == 0) return node;
                node = node.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }
        return null;
    }
}
