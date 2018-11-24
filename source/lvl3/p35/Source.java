package source.lvl3.p35;

import source.support.datastructure.node.TreeNode;

import java.util.Stack;

class Source {
    int pathLengthFromRoot(final TreeNode root, final int N) {
        if(root == null) return 0;
        int x = 0;
        if(root.data == N
            || (x = pathLengthFromRoot(root.right, N)) > 0
            || (x = pathLengthFromRoot(root.left, N)) > 0)
            return x + 1;
        return 0;
    }
    /* ********************************************************************* */
    int pathLengthFromRoot2(final TreeNode root, int N) {
        final Stack<TreeNode> t = new Stack<>();
        final Stack<Integer> i = new Stack<>();
        t.push(root);
        i.push(1);
        while(!t.isEmpty()) {
            TreeNode node = t.pop();
            int depth = i.pop();
            if(node == null) continue;
            if(node.data == N) return depth;
            t.push(node.left);
            t.push(node.right);
            i.push(depth+1);
            i.push(depth+1);
        }
        return 0;
    }
}
