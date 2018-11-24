package source.lvl3.p20;

import source.support.datastructure.tree.BinarySearchTree;
import source.support.datastructure.node.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

class Source {
    int findMaxItr(final TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int max = root.data;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(max < node.data) max = node.data;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return max;
    }
    /* ********************************************************************* */
    int findMaxItr2(final TreeNode root) {
        int max = Integer.MIN_VALUE;
        if(root != null) {
            final LinkedList<TreeNode> q = new LinkedList<>();
            q.add(root);
            TreeNode curr;
            while(!q.isEmpty()) {
                curr = q.remove();
                if(max < curr.data) max = curr.data;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return max;
    }
    /* ********************************************************************* */
    int findMaxItr3(final TreeNode root) {
        int max = Integer.MIN_VALUE;
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            if(node == null) continue;
            max = Math.max(max, node.data);
            stack.push(node.left);
            stack.push(node.right);
        }
        return max;
    }
}
