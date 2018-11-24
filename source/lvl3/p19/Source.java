package source.lvl3.p19;

import source.support.datastructure.node.TreeNode;

import java.util.LinkedList;

class Source {
    TreeNode mirror(final TreeNode root) {
        if(root == null) return null;
        mirror(root.left);
        mirror(root.right);
        final TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        return root; 
    }
    /* ********************************************************************* */
    TreeNode mirror2(final TreeNode root) {
        if(root == null) return null;
        final TreeNode left = root.left;
        root.left = mirror2(root.right);
        root.right = mirror2(left);
        return root;
    }
    /* ********************************************************************* */
    TreeNode mirror3(final TreeNode root) {
        if(root == null) return null;
        final LinkedList<TreeNode> q = new LinkedList<>();
        final LinkedList<TreeNode> m = new LinkedList<>();
        final TreeNode node = new TreeNode(root.data, null, null);
        q.add(root);
        m.add(node);
        while(!q.isEmpty()){
            final TreeNode temp = q.poll();
            final TreeNode curr = m.poll();
            if(temp == null || curr == null) continue;
            if(temp.left == null) curr.right = null;
            else curr.right = new TreeNode(temp.left.data, null, null);
            if(temp.right == null) curr.left = null;
            else curr.left = new TreeNode(temp.right.data, null, null);
            q.add(temp.right);
            q.add(temp.left);
            m.add(curr.left);
            m.add(curr.right);
        }
        return node;
    }
}
