package source.lvl3.p23;

import source.support.datastructure.node.TreeNode;

class Source {
    int diameter(final TreeNode root) {
        if(root == null) return 0;
        return Math.max(height(root.left) + height(root.right) + 1, 
                        Math.max(diameter(root.left), diameter(root.right)));
    }
    private int height(TreeNode root) {
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    /* ********************************************************************* */
    int diameter2(final TreeNode root) {return height2(root)[0];}
    private int[] height2(final TreeNode root) {
        final int[] diameter = {0, 0};
        if(root != null) {
            final int[] lresult = height2(root.left);
            final int[] rresult = height2(root.right);
            final int height = Math.max(lresult[1], rresult[1]) + 1;
            final int ldiameter = lresult[0];
            final int rdiameter = rresult[0];
            final int rootdiameter = lresult[1] + rresult[1] + 1;
            final int finaldiameter = Math.max(rootdiameter, Math.max(ldiameter, rdiameter));
            diameter[0] = finaldiameter;
            diameter[1] = height;
        }
        return diameter;
    }
}
