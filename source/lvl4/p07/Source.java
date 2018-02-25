package source.lvl4.p07;
import source.temp.node.TreeNode;
import source.temp.tree.BinaryTree;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.data == root2.data
            && isMirror(root1.left, root2.right)
            && isMirror(root1.right, root2.left); 
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        BinaryTree t2 = new BinaryTree();
        BinaryTree t3 = new BinaryTree();
        for(int i = 0; i < args.length; i++) {
            int data = Integer.parseInt(args[i]);
            t1.add(data);
            t2.add(data);
        }
        t1.print();
        t2.print();
        t3.print();
        Source obj = new Source();
        System.out.println(obj.isMirror(t1.root, t2.root));
        System.out.println(obj.isMirror(t1.root, t3.root));
        System.out.println(obj.isMirror(t3.root, null));
    }
}
