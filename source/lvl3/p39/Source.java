package source.lvl3.p39;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<Integer> levelorder(TreeNode root) {
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            list.add(node.data);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return list;
    }
    /* ********************************************************************* */
    private ArrayList<Integer> levelorder2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return null;
        TreeNode node = null;
        q.add(root);
        while(!q.isEmpty()) {
            node = (TreeNode) q.remove();
            list.add(node.data);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return list;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().levelorder(tree.root));
        System.out.println(new Source().levelorder2(tree.root));
    }
}
