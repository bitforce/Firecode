package source.lvl4.p11;
import source.support.datastructure.tree.BinaryTree;
import source.support.datastructure.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private ArrayList<Integer> levelorderRev(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        ArrayList<Integer> a = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.add(root);
        while(!q.isEmpty()) { 
            TreeNode node = q.remove();
            if(node.right != null) q.add(node.right); 
            if(node.left != null) q.add(node.left);
            s.add(node.data);
        }
        while(!s.isEmpty()) a.add(s.pop());
        return a;
    }
    /* ********************************************************************* */
    /*
     * BEST SOLUTION
     */
    private ArrayList<Integer> levelorderRev2(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        ArrayList<Integer> a = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.right != null) q.add(node.right);
            if(node.left != null) q.add(node.left);
            a.add(node.data);
        }
        Collections.reverse(a);
        return a;
    }
    /* ********************************************************************* */
    Stack<TreeNode> s = new Stack<>();
    private ArrayList<Integer> levelorderRev3(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        assist(q);
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            a.add(node.data);
        }
        return a;
    }
    private void assist(Queue<TreeNode> q) {
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            s.push(node);
            if(node.right != null) q.add(node.right);
            if(node.left != null) q.add(node.left);
        }
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().levelorderRev(tree.root));
        System.out.println(new Source().levelorderRev2(tree.root));
        System.out.println(new Source().levelorderRev3(tree.root));
    }
}
