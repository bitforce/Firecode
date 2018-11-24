package source.lvl3.p40;
import source.support.datastructure.tree.BinarySearchTree;
import source.support.datastructure.node.TreeNode;

class Source {
    /* ********************************************************************* */
    private TreeNode findMin(TreeNode root) {
        if(root == null) return null;
        while(root.left != null)
            root = root.left;
        return root;
    }
    /* ********************************************************************* */
    private TreeNode findMin2(TreeNode root) {
        if(root == null) return null;
        if(root.left == null) return root;
        return findMin2(root.left);
    }
    /* ********************************************************************* */
    private TreeNode findMin3(TreeNode root) {
        return root==null?null:root.left==null?root:findMin(root.left);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().findMin(tree.root).data);
        System.out.println(new Source().findMin2(tree.root).data);
        System.out.println(new Source().findMin3(tree.root).data);
    }
}
