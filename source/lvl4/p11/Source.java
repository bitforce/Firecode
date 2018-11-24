package source.lvl4.p11;

import source.support.datastructure.tree.BinaryTree;
import source.support.datastructure.node.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

class Source {
    ArrayList<Integer> levelorderRev(final TreeNode root) {
        if(root == null) return new ArrayList<>();
        final ArrayList<Integer> a = new ArrayList<>();
        final LinkedList<TreeNode> q = new LinkedList<>();
        final Stack<Integer> s = new Stack<>();
        q.add(root);
        while(!q.isEmpty()) { 
            TreeNode node = q.remove();
            if(node.right != null) q.add(node.right); 
            if(node.left != null) q.add(node.left);
            s.add(node.data);
        }
        while(!s.isEmpty()) a.add(s.pop());
        return a;
    }
    /* ********************************************************************* */
    ArrayList<Integer> levelorderRev2(final TreeNode root) {
        if(root == null) return new ArrayList<>();
        final ArrayList<Integer> a = new ArrayList<>();
        final LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.right != null) q.add(node.right);
            if(node.left != null) q.add(node.left);
            a.add(node.data);
        }
        Collections.reverse(a);
        return a;
    }
    /* ********************************************************************* */
    final Stack<TreeNode> s = new Stack<>();
    ArrayList<Integer> levelorderRev3(final TreeNode root) {
        if(root == null) return new ArrayList<>();
        final ArrayList<Integer> a = new ArrayList<>();
        final LinkedList<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        assist(q);
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            a.add(node.data);
        }
        return a;
    }
    private void assist(LinkedList<TreeNode> q) {
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            s.push(node);
            if(node.right != null) q.add(node.right);
            if(node.left != null) q.add(node.left);
        }
    }
}
