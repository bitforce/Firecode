package source.lvl2.p03;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private ArrayList<Integer> preorderedList = new ArrayList<>();
    private void preorder(TreeNode root) {
        if(root == null) return;
        preorderedList.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        Source obj = new Source();
        tree.print();
        obj.preorder(tree.root);
        System.out.println(obj.preorderedList);
    }
}
