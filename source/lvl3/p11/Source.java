package source.lvl3.p11;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private ArrayList<Integer> inOrderItr(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.empty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.data);
            node = node.right;
        }
        return list;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().inOrderItr(tree.root).toString()); 
    } 
}
