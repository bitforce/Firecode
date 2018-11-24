package source.lvl3.p21;

import source.support.datastructure.node.TreeNode;

import java.util.LinkedList;

class Source {
    int numberOfFullNodes(final TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        if(root.left != null && root.right != null) count += 1;
        return numberOfFullNodes(root.left) + numberOfFullNodes(root.right) + count;
    }
    /* ********************************************************************* */
    int numberOfFullNodes2(final TreeNode root) {
    if(root == null) return 0;
        return numberOfFullNodes(root.left) +
               numberOfFullNodes(root.right) +
               (root.left!=null&&root.right!=null ? 1 : 0);
    }
    /* ********************************************************************* */
    int numberOfFullNodes3(final TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        TreeNode node;
        while(!q.isEmpty()) {
            node = q.remove();
            if(node.left != null && node.right != null) count++;
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return count;
    }
}
