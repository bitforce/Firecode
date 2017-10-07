package source.lvl3.p23;
import source.temp.tree.BinarySearchTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int diameter(TreeNode root) {
        if(root == null) return 0;
        return Math.max(height(root.left) + height(root.right) + 1, 
                        Math.max(diameter(root.left), diameter(root.right)));
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    /* ********************************************************************* */
    private int diameter2(TreeNode root) {return height2(root)[0];}
    private int[] height2(TreeNode root) {
        int[] diameter = {0, 0};
        if(root != null) {
            int[] lresult = height2(root.left);
            int[] rresult = height2(root.right);
            int height = Math.max(lresult[1], rresult[1]) + 1;
            int ldiameter = lresult[0];
            int rdiameter = rresult[0];
            int rootdiameter = lresult[1] + rresult[1] + 1;
            int finaldiameter = Math.max(rootdiameter, Math.max(ldiameter, rdiameter));
            diameter[0] = finaldiameter;
            diameter[1] = height;
        }
        return diameter;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().diameter(tree.root));
        System.out.println(new Source().diameter2(tree.root));
    }
}
