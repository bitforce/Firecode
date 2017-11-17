package source.lvl2.p02;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int findMax(TreeNode root) {
        int max = root.data;
        if(root.left != null) max = Math.max(max, findMax(root.left));
        if(root.right != null) max = Math.max(max, findMax(root.right));
        return max;
    }
    private int findMax2(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int rootData = Integer.MIN_VALUE;
        int leftData = Integer.MIN_VALUE;
        int rightData = Integer.MIN_VALUE;
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
    private int findMax3(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, 
                Math.max(findMax3(root.left), findMax3(root.right)));
    }
    private int findMax4(TreeNode root) {
        return root == null ? Integer.MIN_VALUE : 
            Math.max(root.data, 
                Math.max(findMax4(root.left), findMax4(root.right)));
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        Source obj = new Source();
        tree.print();
        System.out.println();
        System.out.println(obj.findMax(tree.root));
        System.out.println(obj.findMax2(tree.root));
        System.out.println(obj.findMax3(tree.root));
        System.out.println(obj.findMax4(tree.root));
    }
}
