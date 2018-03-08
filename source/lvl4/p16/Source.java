package source.lvl4.p16;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
        return 0;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        /*
         *                1
         *               2 3
         *              4 5 6
         *             7 8 9 10
         *
         * [[1], [2,3], [4,5,6], [7,8,9,10]]
         *
         * Below I use a BinaryTree to store the single array values as depicted 
         * above, because I couldn't figure out how to create an algorithm that 
         * would one-pass parse and store the array values as such. In addition 
         * to a lack of competence, I figured a tree would naturally fit the 
         * extraction of data into the appropriate ArrayList<ArrayList>> 
         * structure fairly well.
         * 
         * Update:
         * Didn't take into account that there exists "overlapping" nodes; thus,
         * we cannot use tree structure. More simply, imagine how lvl 2 (row 3)
         * 2 of the above triangle would look on a BinaryTree. Thus, we have 
         * to get ride of the lvl order traversal method.
         */
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        // ====================================================================
        // LEVEL ORDER TRAVERSAL & INSERTION
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        ArrayList<TreeNode> tlist = new ArrayList<>();
        tlist.add(tree.root);
        while(!tlist.isEmpty()) {
            ArrayList<TreeNode> temp = new ArrayList<>();
            ArrayList<Integer> lvl = new ArrayList<>();
            while(!tlist.isEmpty()) {
                TreeNode node = tlist.remove(0);
                lvl.add(node.data);
                if(node.left != null) temp.add(node.left);
                if(node.right != null) temp.add(node.right);
            }
            alist.add(lvl);
            tlist = temp;
        }
        // ====================================================================
        System.out.println(alist.toString());
        System.out.println(minTriangleDepth(alist));
    }
}
