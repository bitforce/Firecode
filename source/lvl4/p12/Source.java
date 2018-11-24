package source.lvl4.p12;

import source.support.datastructure.node.TreeNode;

class Source {
    int getNodeDistance(final TreeNode root, final int N1, final int N2) {
        return (length(root, N1) + length(root, N2) - 1) - (2 *
               length(root, lca(root, N1, N2).data) - 1);
    }
    private TreeNode lca(TreeNode root, int N1, int N2) {
        if(root == null) return null;
        if(root.data == N1 || root.data == N2) return root;
        final TreeNode left = lca(root.left, N1, N2);
        final TreeNode right = lca(root.right, N1, N2);
        if(left != null && right != null) return root;
        if(left != null) return left;
        return right;
    }
    int length(final TreeNode root, final int N) {
        if(root == null) return 0;
        int x = 0;
        if(root.data == N
           || (x = length(root.left, N)) > 0
           || (x = length(root.right, N)) > 0) return x + 1;
        return 0;
    }
    /* ********************************************************************* */
    int getNodeDistance2(final TreeNode root, final int N1, final int N2) {
        return -assist(root, N1, N2);
    }
    private int assist(final TreeNode root, final int N1, final int N2) {
            if (root == null) return 0;
            int left = assist(root.left, N1, N2);
            int right = assist(root.right, N1, N2);
            if (left > 0 && right > 0) return -left - right;
            if (left > 0 && (root.data == N1 || root.data == N2)) return -left;
            if (right > 0 && (root.data == N1 || root.data == N2)) return -right;
            if (left > 0) return left + 1;
            if (left < 0) return left;
            if (right > 0) return right + 1;
            if (right < 0) return right;
            if (root.data == N1 || root.data == N2) return 1;
            return 0;
    }
    /* ********************************************************************* */
    int getNodeDistance3(final TreeNode root, final int N1, final int N2) {
        return assist(root, N1, N2, 0)[1];
    }
    private int[] assist(final TreeNode root, final int N1, final int N2, final int level) {
        if (root == null) return new int[] {0, -1};
        final int[] left = assist(root.left, N1, N2, level + 1);
        final int[] right = assist(root.right, N1, N2, level + 1);
        if (root.data == N1 || root.data == N2) {
            if (left[1] > -1) return new int[] {1, 1 + left[1]};
            if (right[1] > -1) return new int[] {1, 1 + right[1]};
            return new int[] {0, 0};
        
        } else if (left[1] > -1 && right[1] > -1) {
            return new int[] {1, 2 + left[1] + right[1]};
        
        } else if (left[1] > -1) {
            if (left[0] == 0) return new int[] {0, 1 + left[1]};
            else return new int[] {1, left[1]};
        } else {
            if (right[0] == 0) 
                return new int[] {0, (right[1] > -1) ? (1 + right[1]) : -1};
            else return new int[] {1, right[1]};
        }
    }
}
