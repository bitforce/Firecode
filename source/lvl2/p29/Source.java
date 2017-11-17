package source.lvl2.p29;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
class Source {
    /* ********************************************************************* */
    private int numberOfLeaves(TreeNode root) { // BEST SOLUTION
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return numberOfLeaves(root.left) + numberOfLeaves(root.right);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().numberOfLeaves(tree.root));
    }
}
