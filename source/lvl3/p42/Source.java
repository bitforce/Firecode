package source.lvl3.p42;

import source.support.datastructure.node.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

class Source {
    int sumItr(final TreeNode root) {
        if(root == null) return 0;
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sum += node.data;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return sum;
    }
    /* ********************************************************************* */
    int sumItr2(final TreeNode root) {
        if (root == null) return 0; 
        TreeNode curr = root;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(curr); 
        int sum = 0;
        while (!q.isEmpty()) {
            curr = q.poll();
            sum += curr.data;
            if (curr.left != null) 
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        return sum;
    }
}
