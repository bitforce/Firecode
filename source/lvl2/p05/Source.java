package source.lvl2.p05;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
class Source {
    /* ********************************************************************* */
    private int size(TreeNode root) {
        if(root == null) return 0;
        return size(root.right) + size(root.left) + 1;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        System.out.println(new Source().size(tree.root));
    }
}
