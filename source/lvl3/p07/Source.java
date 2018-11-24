package source.lvl3.p07;
import source.support.datastructure.tree.BinaryTree;
import source.support.datastructure.node.TreeNode;
class Source {
    /* ********************************************************************* */
    private boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 != null && root2 != null && root1.data == root2.data)
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        return false;
    }
    /* ********************************************************************* */
    private boolean isIdentical2(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
           return true;
        if(root1 == null || root2 == null)
           return false;
        if(root1.data != root2.data)
            return false;
        return isIdentical( root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        BinaryTree t2 = new BinaryTree();
        for(int i = 0; i < args.length/2; i++)
            t1.add(Integer.parseInt(args[i]));
        for(int i = args.length/2; i < args.length; i++)
            t2.add(Integer.parseInt(args[i]));
        Source obj = new Source();
        t1.print();
        t2.print();
        System.out.println(obj.isIdentical(t1.root, t2.root));
        System.out.println(obj.isIdentical2(t1.root, t2.root));
    }
}
