package source.lvl2.p07;
import source.support.datastructure.tree.BinaryTree;
import source.support.datastructure.node.TreeNode;
class Source {
    /* ********************************************************************* */
    private int findHeight(TreeNode root) {
        if(root == null) return 0;
        return findHeight(root.left) + 1;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().findHeight(tree.root));
    }
}
