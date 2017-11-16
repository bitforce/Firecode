package source.lvl3.p42;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int sumItr(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sum += node.data;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return sum;
    }
    /* ********************************************************************* */
    public int sumItr2(TreeNode root) { 
        if (root == null) return 0; 
        TreeNode curr = root;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(curr); 
        int sum = 0;
        while (!q.isEmpty()) {
            curr = q.poll();
            sum += curr.data;
            if (curr.left != null) 
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        return sum;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i <  args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().sumItr(tree.root));
        System.out.println(new Source().sumItr2(tree.root));
    }
}
