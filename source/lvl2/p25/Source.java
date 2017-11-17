package source.lvl2.p25;
import source.temp.tree.BinarySearchTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private TreeNode findNode(TreeNode root, int val) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.data == val) return node;
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        return null;

    }
    /* ********************************************************************* */
    private TreeNode findNode2(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if(node.data == val) return node;
                root = node.right;
            }
        }
        return null;
    }
    /* ********************************************************************* */
    private TreeNode findNode3(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return null;
        queue.add(root);
        while (queue.peek() != null) {
            TreeNode currNode = queue.remove();
            if (currNode.data == val) return currNode;
            if (currNode.left != null) queue.add(currNode.left);
            if (currNode.right != null) queue.add(currNode.right);
        }
        return null;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 1; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[0]);
        Source obj = new Source();
        tree.print();
        System.out.println(obj.findNode(tree.root, N).data);
        System.out.println(obj.findNode2(tree.root, N).data);
        System.out.println(obj.findNode3(tree.root, N).data);
    }
}
