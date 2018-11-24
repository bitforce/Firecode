package source.lvl4.p25;
import source.support.datastructure.tree.BinarySearchTree;
import source.support.datastructure.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private TreeNode delete(TreeNode root, int data) {
        if(root == null) return null;
        if(data < root.data) root.left = delete(root.left, data);
        else if(data > root.data) root.right = delete(root.right, data);
        else {
            if(root.left != null && root.right != null) {
                TreeNode node = root;
                root.data = min(node.right).data;
                root.right = delete(root.right, root.data);
            } else if(root.left != null) root = root.left;
            else if(root.right != null) root = root.right;
            else root = null;
        }
        return root;
    }
    private TreeNode min(TreeNode root) {
        if(root.left == null) return root;
        return min(root.left);
    }
    /* ********************************************************************* */
    public TreeNode delete2(TreeNode root, int data) { 
        if (root == null) return null;
        ArrayList<TreeNode> currNodes = new ArrayList<>();
        currNodes.add(root);
        ArrayList<TreeNode> nextNodes = new ArrayList<>();
        TreeNode parent = null;
        TreeNode nodeForData = null;
        Boolean isLeft = false;
        while(!currNodes.isEmpty()){
            for (TreeNode n : currNodes){
                if (n.data == data){
                    nodeForData = n;
                    break;
                } 
                if (n.left != null){
                    if (n.left.data == data){
                        nodeForData = n.left;
                        parent = n;
                        isLeft = true;
                        break;
                    }
                    nextNodes.add(n.left);
                }
                if (n.right != null){
                    if (n.right.data == data){
                        nodeForData = n.right;
                        parent = n;
                        break;
                    }
                    nextNodes.add(n.right);
                }
            }
            if (nodeForData != null) break;
            currNodes = nextNodes;
            nextNodes = new ArrayList<>();
        }
        if (nodeForData == null) return root;
        if (nodeForData.left == null && nodeForData.right == null){
            if (parent == null) return null;
            else {
                if (isLeft){
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            return root;
        } else if (nodeForData.right != null ^ nodeForData.left != null){
            TreeNode next = nodeForData.right != null ? nodeForData.right : nodeForData.left;
            if (parent == null) root = next;
            else {
                if (isLeft) parent.left = next;
                else parent.right = next;
            }
        } else {
            TreeNode parentOfNext = nodeForData;
            TreeNode next = nodeForData.right;
            boolean isRight = true;
            while(next.left != null){
                parentOfNext = next;
                next = next.left;
                isRight = false;
            }
            nodeForData.data = next.data;
            if (isRight) parentOfNext.right = next.right;
            else parentOfNext.left = next.right;
        }
        return root;
        
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 1; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        new Source().delete(tree.root, Integer.parseInt(args[0]));
        tree.print();
        new Source().delete2(tree.root, Integer.parseInt(args[args.length-1]));
        tree.print();
    }
}
