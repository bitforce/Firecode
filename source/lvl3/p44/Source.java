package source.lvl3.p44;
import source.support.datastructure.tree.BinarySearchTree;
import source.support.datastructure.node.TreeNode;
import java.util.*;
class Source {
    private ArrayList<Integer> rangeList = new ArrayList<Integer>();
    /* ********************************************************************* */
    private void printRange(TreeNode root, int a, int b) {
        if(root == null) return;
        if(a < root.data) printRange(root.left, a, b);
        if(a <= root.data && b >= root.data) rangeList.add(root.data);
        if(b > root.data) printRange(root.right, a, b);
    }
    /* ********************************************************************* */
    public  ArrayList<Integer> rangeList2 = new ArrayList<Integer>();
    public void printRange2(TreeNode root, int min, int max) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.peek();
            if (current.data >= min && current.data <= max)
                rangeList2.add(current.data);
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
            queue.remove();            
        }
        Collections.sort(rangeList2);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 2; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        Source obj = new Source();
        obj.printRange(tree.root, a, b);
        obj.printRange2(tree.root, a, b);
        System.out.println(obj.rangeList.toString());
        System.out.println(obj.rangeList2.toString()); 
    }
}
