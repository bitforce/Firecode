package temp.tree;
import temp.tree.TreePrinter;
import temp.node.TreeNode;
import java.util.*;
/**
 * This version of the binary tree implements a self-balancing insertion method 
 * which attempts to make sure the tree is as balanced as possible, but that 
 * the values need not fit a BST design.
 */
public class BinaryTree {
    public TreeNode root;
    public BinaryTree() {root = null;}
    public void clear() {root = null;}
    public void add(int data) {add(data, root);}
    public void add(int data, TreeNode root) {
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node.left != null && node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    if(node.left == null) node.left = new TreeNode(data, null, null);
                    else node.right = new TreeNode(data, null, null);
                    break;
                }
            }
        } else this.root = new TreeNode(data, null, null);
    }
    public void print() {TreePrinter.print(root);}
}
