import java.util.*;
class BinaryTree {
    private static TreeNode root;

    private BinaryTree() {root = null;}
    /* ********************************************************************* */
    private ArrayList<Integer> inOrderItr(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.empty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.data);
            node = node.right;
        }
        return list;
    }
    /* ********************************************************************* */
    private TreeNode insert(int data) {return root = insert(data, root);}
    private TreeNode insert(int data, TreeNode node) {
        if(node == null) return node = new TreeNode(data);
        if (node.right == null) node.right = insert(data, node.right);
        else node.left = insert(data, node.left);
        return node;
    }

    private TreeNode search(int data) {return search(data, root);}
    private TreeNode search(int data, TreeNode root) {
        if (root == null || root.data == data) return root;
        if (root.data > data) return search(data, root.left);
        return search(data, root.right);
    }

    private void print() {print(0, root);}
    private void print(int level, TreeNode root) {
        if(root == null) return;
        print(level+1, root.right);
        if(level != 0) {
            for(int i = 0; i < level-1; i++)
                System.out.print("|\t");
            System.out.println("|----"+root.data);
        } else System.out.println(root.data);
        print(level+1, root.left);

    }

   public static void main(String[] args) {
       BinaryTree tree = new BinaryTree();
       for (int i = 0; i < args.length; i++)
           tree.insert(Integer.parseInt(args[i]));
       tree.print();
       System.out.println(tree.inOrderItr(root).toString()); 
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
