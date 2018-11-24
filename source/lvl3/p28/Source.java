package source.lvl3.p28;

import source.support.datastructure.node.TreeNode;

class Source {
    static int maxSumPath(TreeNode root) {
        if(root == null) return 0;
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxSumPath(root, max);
        return max[0];
    }
    private static int maxSumPath(TreeNode root, int[] max) {
        if(root == null) return 0;
        int left = maxSumPath(root.left, max);
        int right = maxSumPath(root.right, max);
        int current = Math.max(root.data, Math.max(root.data + left, root.data + right));
        max[0] = Math.max(max[0], Math.max(current, left + root.data + right));
        return current;
    }
}
