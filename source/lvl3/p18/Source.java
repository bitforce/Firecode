package source.lvl3.p18;
import source.temp.tree.BinarySearchTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int numberOfHalfNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        if(root.left == null && root.right != null || 
           root.right == null && root.left != null) count += 1;
        return numberOfHalfNodes(root.left) + numberOfHalfNodes(root.right) + count;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().numberOfHalfNodes(tree.root));
    }
}
