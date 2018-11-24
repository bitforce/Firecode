package source.lvl2.p25;

import source.support.datastructure.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Source {
    TreeNode findNode(TreeNode root, int val) {
        if(root == null) return null;
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.data == val) return node;
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        return null;

    }
    /* ********************************************************************* */
    TreeNode findNode2(TreeNode root, int val) {
        final Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if(node.data == val) return node;
                root = node.right;
            }
        }
        return null;
    }
    /* ********************************************************************* */
    TreeNode findNode3(TreeNode root, int val) {
        final Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return null;
        queue.add(root);
        while (queue.peek() != null) {
            TreeNode currNode = queue.remove();
            if (currNode.data == val) return currNode;
            if (currNode.left != null) queue.add(currNode.left);
            if (currNode.right != null) queue.add(currNode.right);
        }
        return null;
    }
}
