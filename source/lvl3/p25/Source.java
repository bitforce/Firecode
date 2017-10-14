package source.lvl3.p25;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int minTreeDepth(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            count++;
            if(node.left == null && node.right == null) break;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return count;
    }
    /* ********************************************************************* */
    private int minTreeDepth2(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        curr.add(root);
        while(!curr.isEmpty()) {
            TreeNode node = curr.poll();
            if(node.left == null && node.right == null) 
                return depth;
            if(node.left != null) next.add(node.left);
            if(node.right != null) next.add(node.right);
            if(curr.isEmpty()) {
                depth++;
                curr = next;
                next = new LinkedList<>();
            }
        }
        return depth;
    }
    /* ********************************************************************* */ 
    private int minTreeDepth3(TreeNode root) {
        Stack<TreeNode> tstack = new Stack<>();
        Stack<Integer> istack = new Stack<>();
        tstack.push(root);
        istack.push(0);
        int min = Integer.MAX_VALUE;
        while(!tstack.isEmpty()) {
            TreeNode node = tstack.pop();
            Integer depth = istack.pop();
            if(depth >= min) continue;
            if(node == null) {
                min = Math.min(min, depth);
                continue;
            }
            istack.push(depth + 1);
            istack.push(depth + 1);
            tstack.push(node.left);
            tstack.push(node.right);
        }
        return min;
    } 
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().minTreeDepth(tree.root));
        System.out.println(new Source().minTreeDepth2(tree.root)); 
        System.out.println(new Source().minTreeDepth3(tree.root)); 
    }
}
