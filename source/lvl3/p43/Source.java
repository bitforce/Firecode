package source.lvl3.p43;
import source.support.datastructure.tree.BinarySearchTree;
import source.support.datastructure.node.TreeNode;

class Source {
    /* ********************************************************************* */
    private TreeNode insert(TreeNode root, int data) {
        if(root == null) return new TreeNode(data, null, null);
        if(root.data >= data) root.left = insert(root.left, data);
        if(root.data < data) root.right = insert(root.right, data);
        return root;
    }
    /* ********************************************************************* */
    private TreeNode insert2(TreeNode root, int data) {
        if(root == null) return new TreeNode(data, null, null);
        TreeNode node = root;
        while(true) {
            if(data <= node.data) {
                if(node.left != null) node = node.left;
                else {
                    node.left = new TreeNode(data, null, null);
                    return root;
                }
            } else {
                if(node.right != null) node = node.right;
                else {
                    node.right = new TreeNode(data, null, null);
                    return root;
                }
            }
        }
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 1; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        int data = Integer.parseInt(args[0]);
        tree.root = new Source().insert(tree.root, data);
        tree.root = new Source().insert2(tree.root, data+1);
        tree.print();
    }
}
