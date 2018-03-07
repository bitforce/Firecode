package source.lvl4.p14;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int findMaxSumLevel(TreeNode root) {
        if(root == null) return -1;
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            ArrayList<TreeNode> temp = new ArrayList<>();
            ArrayList<Integer> level = new ArrayList<>();
            while(!nodes.isEmpty()) {
                TreeNode node = nodes.remove(0);
                level.add(node.data);
                if(node.left != null) temp.add(node.left);
                if(node.right != null) temp.add(node.right);
            }
            levels.add(level);
            nodes = temp;
        } 
        int max = 0;
        int lvl = 0;
        for(int i = 0; i < levels.size(); i++) {
            int temp = 0;
            for(Integer j : levels.get(i)) temp += j;
            lvl = max < temp ? i : lvl;
            max = max < temp ? temp : max;
        }
        return max == 0 ? -1 : lvl;
    }
    /* ********************************************************************* */
    // BEST SOLUTION
    private int findMaxSumLevel2(TreeNode root) {                    
        if(root == null) return -1;
        int sum = 0, maxSum = 0;
        int lvl = 0, maxLvl = 0;
        TreeNode node = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            node = q.remove();
            if(node == null) {
                if(sum > maxSum) {
                    maxSum = sum;
                    maxLvl = lvl;
                }
                sum = 0;
                if(!q.isEmpty()) q.add(null);
                lvl++;
            } else {
                sum += node.data;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return maxLvl;
    }
    /* ********************************************************************* */
    public int findMaxSumLevel3(TreeNode root) { 
        ArrayList<Integer> sums = new ArrayList<Integer>();
        findMaxSumLevel3(root, 0, sums);
        if (sums.size() == 0) return -1;
        int max = 0;
        for (int level = 0; level < sums.size(); level++)
            max = sums.get(level) > sums.get(max) ? level : max;
        return max;
    }
    private void findMaxSumLevel3(TreeNode root, int level, 
                                  ArrayList<Integer> sums) {
        if (root == null) return;
        if (level == sums.size()) sums.add(0);
        sums.set(level, sums.get(level) + root.data);
        findMaxSumLevel3(root.left, level + 1, sums);
        findMaxSumLevel3(root.right, level + 1, sums);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().findMaxSumLevel(tree.root));
        System.out.println(new Source().findMaxSumLevel2(tree.root));
        System.out.println(new Source().findMaxSumLevel3(tree.root));
    }
}
