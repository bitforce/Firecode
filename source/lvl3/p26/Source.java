package source.lvl3.p26;

import source.support.datastructure.node.TreeNode;

import java.util.LinkedList;

class Source {
    TreeNode findDeepest(final TreeNode root) {
        if(root == null) return null;
        final LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode node = root;
        while(!q.isEmpty()) {
            node = q.poll();
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return node;
    }
}
