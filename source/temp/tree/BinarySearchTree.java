package source.temp.tree;
import source.temp.help.TreePrinter;
import source.temp.node.TreeNode;
/**
 * This is your standard binary search tree which utilizes a ordering-insertion 
 * method to make sure that the tree's strucutre follows the the BST design 
 * principles--if you would like to have a basic, but balanced, insertion 
 * of values, check out BinaryTree.java instead.
 */
public class BinarySearchTree {
    public TreeNode root;
    public BinarySearchTree() {root = null;}
    public void clear() {root = null;}
    public void add(int data) {root = add(data, root);}
    public TreeNode add(int data, TreeNode root) {
        if(root == null) return new TreeNode(data, null, null);
        if(data <= root.data) root.left = add(data, root.left);
        if(data > root.data) root.right = add(data, root.right);
        return root;
    }
    public void print() {TreePrinter.print(root);}
}
