package source.lvl3.p36;
import source.temp.tree.BinarySearchTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    int count = 0;
    private TreeNode findKthSmallest(TreeNode root, int k) {
        if(root == null || k < 1) return null;
        TreeNode node = findKthSmallest(root.left, k);
        if(count != k) {
            node = root;
            count++;
        }
        if(count == k) return node;
        return findKthSmallest(node.right, k);
    }
    /* ********************************************************************* */
    private TreeNode findKthSmallest2(TreeNode root, int k) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node == null) {
                node = stack.pop();
                if(--k == 0) return node;
                node = node.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }
        return null;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        final int K = Integer.parseInt(args[0]);
        for(int i = 1; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().findKthSmallest(tree.root, K).data);
        System.out.println(new Source().findKthSmallest2(tree.root, K).data);
    }
}
