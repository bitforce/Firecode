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
    private int findMaxSumLevel2(TreeNode root) {                    
        if(root == null) return -1;
        int currSum = 0, maxSum = 0;
        int currLvl = 0, maxLvl = 0;
        TreeNode curr = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null); //end of first level indicator
        while(!q.isEmpty()) {
            curr = q.remove();
            // If at the end of current level, compare sum and process result
            if(curr == null) {
                if(currSum > maxSum) {
                    maxSum = currSum;
                    maxLvl = currLvl;
                }
                currSum = 0; //reset
                if(!q.isEmpty())
                    q.add(null); //end of level indicator
                currLvl++; //begin next level
            } else {
                currSum += curr.data;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                    
            }
        }
        return maxLvl;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(new Source().findMaxSumLevel(tree.root));
        System.out.println(new Source().findMaxSumLevel2(tree.root));
    }
}
