package source.lvl3.p15;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private String serializeTree(TreeNode root) {return serializeTree(root, "");}
    private String serializeTree(TreeNode root, String s) {
        if(root == null) return "null";
        String r = root.data + ",";
        r += serializeTree(root.left, r) + ",";
        r += serializeTree(root.right, r);
        return r;
    }
    private TreeNode restoreTree(String s) {return restoreTree(s.split(","), new int[]{0});}
    private TreeNode restoreTree(String[] s, int[] i) {
        if(i[0] > s.length || s[i[0]].equals("null")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s[i[0]++]), null, null);
        node.left = restoreTree(s, i);
        node.right = restoreTree(s, i);
        return node;
    }
    /* ********************************************************************* */
    private String serializeTree2(TreeNode root) {
        if(root == null) return "none,";
        return String.valueOf(root.data) + "," 
                                         + serializeTree2(root.left) 
                                         + serializeTree2(root.right);
    }
    private TreeNode restoreTree2(String s) {
        return restoreTree2(new LinkedList<String>(Arrays.asList(s.split(","))));
    }
    private TreeNode restoreTree2(List<String> list) {
        String s = list.remove(0);
        if(s.equals("none")) return null;
        return new TreeNode(Integer.valueOf(s), 
                            restoreTree2(list), 
                            restoreTree2(list));
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < args.length; i++)
            tree.add(Integer.parseInt(args[i]));
        tree.print();
        System.out.println(tree.root); 
        BinaryTree copy = new BinaryTree();
        copy.root = new Source().restoreTree(new Source().serializeTree(tree.root));
        copy.print();
        System.out.println(copy.root); 
        BinaryTree copy2 = new BinaryTree();
        copy2.root = new Source().restoreTree2(new Source().serializeTree2(tree.root));
        copy2.print();
        System.out.println(copy2.root); 
    }
}
