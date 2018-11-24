package source.lvl3.p15;

import source.support.datastructure.node.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Source {
    String serializeTree(TreeNode root) {return serializeTree(root, new StringBuilder());}
    private String serializeTree(final TreeNode root, StringBuilder sb) {
        if(root == null) return "null";
        sb.append(root.data).append(",");
        sb.append(serializeTree(root.left, sb)).append(",");
        sb.append(serializeTree(root.right, sb));
        return sb.toString();
    }
    TreeNode restoreTree(final String s) {return restoreTree(s.split(","), new int[]{0});}
    private TreeNode restoreTree(final String[] s, final int[] i) {
        if(i[0] > s.length || s[i[0]].equals("null")) {
            i[0]++;
            return null;
        }
        final TreeNode node = new TreeNode(Integer.parseInt(s[i[0]++]), null, null);
        node.left = restoreTree(s, i);
        node.right = restoreTree(s, i);
        return node;
    }
    /* ********************************************************************* */
    String serializeTree2(final TreeNode root) {
        if(root == null) return "none,";
        return String.valueOf(root.data) + "," 
                                         + serializeTree2(root.left) 
                                         + serializeTree2(root.right);
    }
    TreeNode restoreTree2(final String s) {
        return restoreTree2(new LinkedList<>(Arrays.asList(s.split(","))));
    }
    private TreeNode restoreTree2(final List<String> list) {
        final String s = list.remove(0);
        if(s.equals("none")) return null;
        return new TreeNode(Integer.valueOf(s), 
                            restoreTree2(list), 
                            restoreTree2(list));
    }
}
