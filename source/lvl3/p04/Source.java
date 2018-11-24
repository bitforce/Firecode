package source.lvl3.p04;

import source.support.datastructure.node.TreeNode;

import java.util.Stack;

class Source {
    private int counter;
    TreeNode findKthLargest(final TreeNode root, final int k) {
        if (root == null) return null;
        TreeNode node = findKthLargest(root.right, k);
        if (counter != k) {
            node = root;
            counter++;
        }
        if (counter == k) return node;
        return findKthLargest(root.left, k);
    }
    /* ********************************************************************* */
    TreeNode findKthLargest2(final TreeNode root, int k) {
        if (root == null) return null;
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) 
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                if (k-- == 1) break;
                node = node.left;
            }
        return node;
    }
}
