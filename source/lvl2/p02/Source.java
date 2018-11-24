package source.lvl2.p02;

import source.support.datastructure.node.TreeNode;

class Source {
    int findMax(TreeNode root) {
        int max = root.data;
        if(root.left != null) max = Math.max(max, findMax(root.left));
        if(root.right != null) max = Math.max(max, findMax(root.right));
        return max;
    }
    /* ********************************************************************* */
    int findMax2(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int rootData;
        int leftData;
        int rightData;
        if(root != null) {
            rootData = root.data;
            leftData = findMax2(root.left);
            rightData = findMax2(root.right);
            if(leftData > rightData) max = leftData;
            else max = rightData;
            if(max < rootData) max = rootData;
        }
        return max;
    }
     /* ********************************************************************* */
    int findMax3(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, 
                Math.max(findMax3(root.left), findMax3(root.right)));
    }
    /* ********************************************************************* */
    int findMax4(TreeNode root) {
        return root == null ? Integer.MIN_VALUE : 
            Math.max(root.data, 
                Math.max(findMax4(root.left), findMax4(root.right)));
    }
}
