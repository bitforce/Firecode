package source.temp.node;
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int data) {
        this.data = data;
<<<<<<< HEAD
        left = null;
        right = null;
=======
        this.left = null;
        this.right = null;
>>>>>>> 412e1f574383a7bf63be5a60f47fb93800ba4d16
    }
    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}  
