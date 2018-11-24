package source.lvl3.p02;

import source.support.datastructure.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Source {
    ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
        final ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        if(root == null) return levels;
        ArrayList<Integer> values = new ArrayList<>();
        LinkedList<TreeNode> curr = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        curr.add(root);
        while(!curr.isEmpty()) {
            TreeNode node = curr.remove();
            if(node.left != null) next.add(node.left);
            if(node.right != null) next.add(node.right);
            values.add(node.data);
            if(curr.isEmpty()) {
                curr = next;
                next = new LinkedList<TreeNode>();
                levels.add(values);
                values = new ArrayList<Integer>();
            }
        }
        return levels;
    }
    /* ********************************************************************* */
    ArrayList<ArrayList<Integer>> printLevelByLevel2(TreeNode root) {
        final ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        if (root == null) return solution;
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {        
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                root = queue.remove();
                level.add(root.data);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            solution.add(level);
        }
        return solution;
    }
}
