import java.util.*;
class BinaryTree {
    private static TreeNode root;
    private BinaryTree() {root = null;}
    /* ********************************************************************* */
    private ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        if(root == null) return levels;
        ArrayList<Integer> values = new ArrayList<>();
        LinkedList<TreeNode> curr = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        curr.add(root);
        while(!curr.isEmpty()) {
            TreeNode node = curr.remove();
            if(node.left != null) next.add(node.left);
            if(node.right != null) next.add(node.right);
            values.add(node.data);
            if(curr.isEmpty()) {
                curr = next;
                next = new LinkedList<TreeNode>();
                levels.add(values);
                values = new ArrayList<Integer>();
            }
        }
        return levels;
    }
    public ArrayList<ArrayList<Integer>> printLevelByLevel2(TreeNode root) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        if (root == null) return solution;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {        
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                root = queue.remove();
                level.add(root.data);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            solution.add(level);
        }
        return solution;
    } // BEST SOLUTION
    /* ********************************************************************* */
    private TreeNode insert(int data) {return root = insert(data, root);}
    private TreeNode insert(int data, TreeNode node) {
        if(node == null) return node = new TreeNode(data);
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
            System.out.println("|----{"+root.data);
        } else System.out.println(root.data);
        print(root.left, level+1);
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
           tree.insert(Integer.parseInt(args[i]));
        tree.print(root, 0);
        System.out.println();
        System.out.println(tree.printLevelByLevel(root));
        System.out.println(tree.printLevelByLevel2(root));
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
