import java.util.*;
class BinaryTree {
    private static TreeNode root;
    private BinaryTree() {root = null;}
    /* ********************************************************************* */
    private ArrayList<Integer> ancestorsList = new ArrayList<>();
    private boolean printAncestors(TreeNode root, int nodeData) {
        if(root == null) return false;
        if(root.data == nodeData) return true;       
        if (printAncestors(root.left, nodeData) 
                || printAncestors(root.right, nodeData)) {
            ancestorsList.add(root.data);
            return true;
        }
        return false;
    }
    private boolean printAncestors2(TreeNode root, int nodeData) {
        if(root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            while(root != null && root.data != nodeData) {
                stack.push(root);
                root = root.left;
            }
            if(root != null && root.data == nodeData) break;
            if(stack.peek().right == null) {
                root =stack.peek();
                stack.pop();
                while( stack.empty() == false && stack.peek().right == root) {
                    root = stack.peek();
                    stack.pop();
                }
            }
            root = stack.empty() ? null : stack.peek().right;
        }
        while(!stack.empty()) {
            ancestorsList.add(stack.peek().data);
            stack.pop();
        }
        return true;
    }
    /* ********************************************************************* */
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
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length-1; i++)
           tree.insert(Integer.parseInt(args[i+1]));
        tree.print(root, 0);
        System.out.println();
        System.out.println(tree.printAncestors(root, Integer.parseInt(args[0])));
        System.out.println(tree.ancestorsList.toString());
    }
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {this.data = data;}
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
