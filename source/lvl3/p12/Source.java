package source.lvl3.p12;

import source.support.datastructure.tree.BinaryTree;
import source.support.datastructure.node.TreeNode;
import java.util.*;

class Source {
    static boolean validateBSTItr(TreeNode root) {
        if(root == null) return true;
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode node = null;
        while(!stack.isEmpty() || root != null)
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(node != null && root.data <= node.data)
                    return false;
                node = root;
                root = root.right;
            }
        return true;
    }
    /* ********************************************************************* */
    static boolean validateBSTItr2(final TreeNode root) {
        class Data {
            TreeNode node;
            int min;
            int max;
            Data(TreeNode node, int min, int max) {
                this.node = node;
                this.min = min;
                this.max = max;
            }
        }
        if(root == null) return true;
        final Queue<Data> q = new LinkedList<>();
        q.offer(new Data(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while(!q.isEmpty()) {
            Data store = q.poll();
            if(store.node.data >= store.max || store.node.data <= store.min)
                return false;
            if(store.node.left !=null) 
                q.offer(new Data(store.node.left, store.min, store.node.data));
            if(store.node.right !=null)
                q.offer(new Data(store.node.right, store.node.data, store.max));
        }
        return true;
    }
    /* ********************************************************************* */
    static boolean validateBSTItr3(TreeNode root) {
        class Boundary {
            TreeNode node;
            int lBoundary;
            int rBoundary;
            Boundary(TreeNode node, int lBoundary, int rBoundary) {
                this.node = node;
                this.lBoundary = lBoundary;
                this.rBoundary = rBoundary;
            }
        }
        if(root == null || root.left == null && root.right == null) return true;
        final Queue<Boundary> q = new LinkedList<>();
        q.add(new Boundary(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while(!q.isEmpty()) {
            Boundary bound = q.poll();
            TreeNode node = bound.node;
            if(node.data <= bound.lBoundary || node.data >= bound.rBoundary) return false;
            if(node.left != null) q.add(new Boundary(node.left, bound.lBoundary, node.data));
            if(node.right != null) q.add(new Boundary(node.right, node.data, bound.rBoundary));
        }
        return true;
    }
}
