import java.util.*;
class BST {
    private static TreeNode root;
    private BST() {root = null;}
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
        BST tree = new BST();
        for(int i = 1; i < args.length; i++)
            tree.insert(Integer.parseInt(args[i]));
        System.out.println(tree.findNode(root, Integer.parseInt(args[0])));
        System.out.println(tree.findNode2(root, Integer.parseInt(args[0])));
        System.out.println(tree.findNode3(root, Integer.parseInt(args[0])));
        System.out.println();
        tree.print(root, 0);
    }
    private TreeNode insert(int data) {return root = insert(data, root);}
    private TreeNode insert(int data, TreeNode node) {
        if(node == null) return node = new TreeNode(data, null, null);
        if (node.right == null) node.right = insert(data, node.right);
        else node.left = insert(data, node.left);
        return node;
    }
    private void print(TreeNode root, int level) {
        if(root == null) return;
        print(root.right, level+1);
        if(level != 0) {
            for(int i = 0; i < level-1; i++)
                System.out.print("|\t");
            System.out.println("|----"+root.data);
        } else System.out.println(root.data);
        print(root.left, level+1);
    }
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;     
        TreeNode(){}
        TreeNode(int data) {this.data = data;}
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }   
}
