package source.lvl3.p35;
import source.support.datastructure.tree.BinaryTree;
import source.support.datastructure.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int pathLengthFromRoot(TreeNode root, int n1) {
        if(root == null) return 0;
        int x = 0;
        if(root.data == n1 
            || (x = pathLengthFromRoot(root.right, n1)) > 0
            || (x = pathLengthFromRoot(root.left, n1)) > 0)
            return x + 1;
        return 0;
    }
    /* ********************************************************************* */
    private int pathLengthFromRoot2(TreeNode root, int n1) {
        Stack<TreeNode> t = new Stack<>();
        Stack<Integer> i = new Stack<>();
        t.push(root);
        i.push(1);
        while(!t.isEmpty()) {
            TreeNode node = t.pop();
            int depth = i.pop();
            if(node == null) continue;
            if(node.data == n1) return depth;
            t.push(node.left);
            t.push(node.right);
            i.push(depth+1);
            i.push(depth+1);
        }
        return 0;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 1; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        int n1 = Integer.parseInt(args[0]);
        System.out.println(new Source().pathLengthFromRoot(tree.root, n1));
        System.out.println(new Source().pathLengthFromRoot2(tree.root, n1));
    }
}
