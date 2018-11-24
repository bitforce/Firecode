package source.lvl4.p12;
import source.support.datastructure.tree.BinaryTree;
import source.support.datastructure.node.TreeNode;

class Source {
    /* ********************************************************************* */
    private int getNodeDistance(TreeNode root, int n1, int n2) { 
        return (length(root, n1) + length(root, n2) - 1) - (2 * 
               length(root, lca(root, n1, n2).data) - 1); 
    }
    private TreeNode lca(TreeNode root, int n1, int n2) {
        if(root == null) return null;
        if(root.data == n1 || root.data == n2) return root;
        TreeNode left = lca(root.left, n1, n2);
        TreeNode right = lca(root.right, n1, n2);
        if(left != null && right != null) return root;
        if(left != null) return left;
        return right;
    }
    private int length(TreeNode root, int n) {
        if(root == null) return 0;
        int x = 0;
        if(root.data == n
           || (x = length(root.left, n)) > 0 
           || (x = length(root.right, n)) > 0) return x + 1;
        return 0;
    }
    /* ********************************************************************* */
    private int getNodeDistance2(TreeNode root, int n1, int n2) {
        return -assist(root, n1, n2);
    }
    private int assist(TreeNode root, int n1, int n2) {
            if (root == null) return 0;
            int left = assist(root.left, n1, n2);
            int right = assist(root.right, n1, n2);
            if (left > 0 && right > 0) return -left - right;
            if (left > 0 && (root.data == n1 || root.data == n2)) return -left;
            if (right > 0 && (root.data == n1 || root.data == n2)) return -right;
            if (left > 0) return left + 1;
            if (left < 0) return left;
            if (right > 0) return right + 1;
            if (right < 0) return right;
            if (root.data == n1 || root.data == n2) return 1;
            return 0;
    }
    /* ********************************************************************* */
    private int getNodeDistance3(TreeNode root, int n1, int n2) {
        return assist(root, n1, n2, 0)[1];
    }
    private int[] assist(TreeNode root, int n1, int n2, int level) {
        if (root == null) return new int[] {0, -1};
        int[] left = assist(root.left, n1, n2, level + 1);
        int[] right = assist(root.right, n1, n2, level + 1);
        if (root.data == n1 || root.data == n2) {
            if (left[1] > -1) return new int[] {1, 1 + left[1]};
            if (right[1] > -1) return new int[] {1, 1 + right[1]};
            return new int[] {0, 0};
        
        } else if (left[1] > -1 && right[1] > -1) {
            return new int[] {1, 2 + left[1] + right[1]};
        
        } else if (left[1] > -1) {
            if (left[0] == 0) return new int[] {0, 1 + left[1]};
            else return new int[] {1, left[1]};
        } else {
            if (right[0] == 0) 
                return new int[] {0, (right[1] > -1) ? (1 + right[1]) : -1};
            else return new int[] {1, right[1]};
        }
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 2; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        System.out.println(new Source().getNodeDistance(tree.root, n1, n2));
        System.out.println(new Source().getNodeDistance2(tree.root, n1, n2));
        System.out.println(new Source().getNodeDistance3(tree.root, n1, n2));
    }
}
