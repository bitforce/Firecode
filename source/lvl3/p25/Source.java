package source.lvl3.p25;

import source.support.datastructure.node.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

class Source {
    int minTreeDepth(final TreeNode root) {
        if(root == null) return 0;
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            count++;
            if(node.left == null && node.right == null) break;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return count;
    }
    /* ********************************************************************* */
    int minTreeDepth2(final TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        LinkedList<TreeNode> curr = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        curr.add(root);
        while(!curr.isEmpty()) {
            TreeNode node = curr.poll();
            if(node.left == null && node.right == null) 
                return depth;
            if(node.left != null) next.add(node.left);
            if(node.right != null) next.add(node.right);
            if(curr.isEmpty()) {
                depth++;
                curr = next;
                next = new LinkedList<>();
            }
        }
        return depth;
    }
    /* ********************************************************************* */
    int minTreeDepth3(final TreeNode root) {
        final Stack<TreeNode> tstack = new Stack<>();
        final Stack<Integer> istack = new Stack<>();
        tstack.push(root);
        istack.push(0);
        int min = Integer.MAX_VALUE;
        while(!tstack.isEmpty()) {
            final TreeNode node = tstack.pop();
            Integer depth = istack.pop();
            if(depth >= min) continue;
            if(node == null) {
                min = Math.min(min, depth);
                continue;
            }
            istack.push(depth + 1);
            istack.push(depth + 1);
            tstack.push(node.left);
            tstack.push(node.right);
        }
        return min;
    }
}
