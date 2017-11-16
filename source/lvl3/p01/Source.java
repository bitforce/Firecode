package source.lvl3.p01;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
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
    /* ********************************************************************* */
    private ArrayList<Integer> ancestorsList2 = new ArrayList<>();
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
            ancestorsList2.add(stack.peek().data);
            stack.pop();
        }
        return true;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 1; i < args.length; i++)
           tree.add(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[0]);
        tree.print();
        System.out.println();
        Source obj = new Source();
        System.out.println(obj.printAncestors(tree.root, N));
        System.out.println(obj.ancestorsList.toString());
        System.out.println(obj.printAncestors2(tree.root, N));
        System.out.println(obj.ancestorsList2.toString());
    }
}
