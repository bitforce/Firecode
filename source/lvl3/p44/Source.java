package source.lvl3.p44;

import source.support.datastructure.node.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

class Source {
    ArrayList<Integer> rangeList = new ArrayList<Integer>();
    void printRange(TreeNode root, int a, int b) {
        if(root == null) return;
        if(a < root.data) printRange(root.left, a, b);
        if(a <= root.data && b >= root.data) rangeList.add(root.data);
        if(b > root.data) printRange(root.right, a, b);
    }
    /* ********************************************************************* */
    ArrayList<Integer> rangeList2 = new ArrayList<>();
    void printRange2(TreeNode root, int min, int max) {
        if (root == null) return;
        final LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.peek();
            if (current.data >= min && current.data <= max)
                rangeList2.add(current.data);
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
            queue.remove();            
        }
        Collections.sort(rangeList2);
    }
}
