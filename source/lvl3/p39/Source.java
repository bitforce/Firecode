package source.lvl3.p39;

import source.support.datastructure.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

class Source {
    private ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> levelorder(TreeNode root) {
        if(root == null) return list;
        final LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            list.add(node.data);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return list;
    }
    /* ********************************************************************* */
    ArrayList<Integer> levelorder2(TreeNode root) {
        final ArrayList<Integer> list = new ArrayList<>();
        final LinkedList<TreeNode> q = new LinkedList<>();
        if(root == null) return null;
        TreeNode node;
        q.add(root);
        while(!q.isEmpty()) {
            node = q.remove();
            list.add(node.data);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return list;
    }
}
