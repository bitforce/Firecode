package source.lvl3.p04;
import source.temp.tree.BinarySearchTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int counter;
    private TreeNode findKthLargest(TreeNode root, int k) {
        if (root == null) return null;
        TreeNode node = findKthLargest(root.right, k);
        if (counter != k) {
            node = root;
            counter++;
        }
        if (counter == k) return node;
        return findKthLargest(root.left, k);
    }
    /* ********************************************************************* */
    private TreeNode findKthLargest2(TreeNode root, int k) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) 
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                if (k-- == 1) break;
                node = node.left;
            }
        return node;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 1; i < args.length; i++)
           tree.add(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[0]);
        Source obj = new Source();
        tree.print();
        System.out.println(obj.findKthLargest(tree.root, N).data);
        System.out.println(obj.findKthLargest2(tree.root, N).data);
    }
}
