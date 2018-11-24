package source.lvl3.p24;

import source.support.datastructure.node.TreeNode;

import java.util.Stack;

class Source {
    /* ********************************************************************* */
    TreeNode findMax(final TreeNode root) {
        if(root == null || root.right == null && root.left == null) return root;
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int max = root.data;
        TreeNode node = root;
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if(max < temp.data) {
                max = temp.data;
                node = temp;
            }
            if(temp.left != null) stack.push(temp.left);
            if(temp.right != null) stack.push(temp.right);
        }
        return node;
    }
    /* ********************************************************************* */
    TreeNode findMax2(final TreeNode root) {
        if(root == null) return null;
        if(root.right == null) return root;
        return findMax2(root.right);
    }
    /* ********************************************************************* */
    TreeNode findMax3(TreeNode root) {
        if(root == null) return null;
        while(root.right != null) root = root.right;
        return root;
    }
}
