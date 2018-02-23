package source.lvl4.p05;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
<<<<<<< HEAD
        if(root == null || root.left == nul && root.right == null)
            return root;
        //
=======
        if(root == null) return null;
        if(root.data == a.data || root.data == b.data) return root;
        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
    /* ********************************************************************* */
    private TreeNode findLCA2(TreeNode root, TreeNode a, TreeNode b) {
        TreeNode left, right = null;
        if(root == null || a == null || b == null) return null;
        if(root == a || root == b) return root;
        left = findLCA2(root.left, a, b);
        right = findLCA2(root.right, a, b);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
    /* ********************************************************************* */
    private TreeNode findLCA3(TreeNode root, TreeNode a, TreeNode b) {
        if(root == null || root == a || root == b) return root;
        TreeNode left = findLCA3(root.left, a , b);
        TreeNode right = findLCA3(root.right, a, b);
        if(right != null && left != null) return root;
        return right != null ? right : left;
>>>>>>> 412e1f574383a7bf63be5a60f47fb93800ba4d16
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 2; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
<<<<<<< HEAD
        tree.print();
        System.out.println(new Source().findLCA(tree.root, a, b).data);
=======
        Source obj = new Source();
        tree.print();
//        System.out.println(obj.findLCA(tree.root, new TreeNode(a),
//                           new TreeNode(b)).data);
//        System.out.println(obj.findLCA2(tree.root, new TreeNode(a),
//                           new TreeNode(b)).data);
        System.out.println(obj.findLCA3(tree.root, new TreeNode(a),
                           new TreeNode(b)).data);

>>>>>>> 412e1f574383a7bf63be5a60f47fb93800ba4d16
    }
}
