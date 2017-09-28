package templates;
import templates.TreeNode;
import templates.TreePrinter;
/**
 * This version of the binary tree implements a self-balancing insertion method 
 * which does not necessarily order all the elements to fit the design of a
 * binary search tree, but does make sure that the tree's branches is as 
 * even are as even as possible; however, there is an ability to turn on 
 * and off this balancing act (;D) so that you can decide when to do it.
 */
public class BinaryTree {
    public TreeNode root;
    public BinaryTree() {root = null;}
    public void clear() {root = null;}
    public void add(int data) {root = add(data, root);}
    public TreeNode add(int data, TreeNode root) {
        if(root == null) return new TreeNode(data, null, null);
        if(data <= root.data) root.left = add(data, root.left);
        if(data > root.data) root.right = add(data, root.right);
        return root;
    }
    public void balance(TreeNode root) {
        return;
    }
    public void print() {TreePrinter.print(root);}
}
