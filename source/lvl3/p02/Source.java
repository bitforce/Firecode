package source.lvl3.p02;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
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
    /* ********************************************************************* */
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
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
           tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println();
        Source obj = new Source();
        System.out.println(obj.printLevelByLevel(tree.root));
        System.out.println(obj.printLevelByLevel2(tree.root));
    }
}
