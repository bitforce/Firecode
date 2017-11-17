package source.lvl2.p06;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
class Source {
    /* ********************************************************************* */
    private int sum(TreeNode root) {
        if(root == null) return 0;
        return sum(root.right) + sum(root.left) + root.data;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        System.out.println(new Source().sum(tree.root));
    }
}
