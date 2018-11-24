package source.lvl3.p46;

import source.support.datastructure.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

class Source {
    TreeNode decompressTree(final String str) {
        if(str == null || str.equals("*") || str.startsWith("*")) return null;
        final LinkedList<TreeNode> parents = new LinkedList<>();
        final LinkedList<Integer> numbers = new LinkedList<>();
        for(String s : str.split(","))
            numbers.add("*".equals(s) ? null : Integer.parseInt(s));
        final TreeNode root = new TreeNode(numbers.remove(), null, null);
        parents.add(root);
        while(!numbers.isEmpty()) {
            Integer left = numbers.remove();
            Integer right = numbers.remove();
            TreeNode parent = parents.remove();
            if(parent != null) {
                parent.left = left != null ? new TreeNode(left, null, null) : null;
                parent.right = right != null ? new TreeNode(right, null, null) : null;
                parents.add(parent.left);
                parents.add(parent.right);
            }
        }
        return root;
    }
    /* ********************************************************************* */
    TreeNode decompressTree2(final String str){
        if(str == null || str.equals("") || str.equals("*")) return null;
        final ArrayList<Integer> nodes = new ArrayList<>();
        final String[] splits = str.split(",");
        for(String s: splits){
            Integer i = s.equals("*") ? null : Integer.valueOf(s);
            nodes.add(i);
        }
        final LinkedList<TreeNode> queue = new LinkedList<>();
        int size = nodes.size();
        int i = 0;
        final TreeNode root = new TreeNode(nodes.get(0), null, null);
        queue.add(root);
        while(i < nodes.size()){
            final TreeNode t = queue.poll();
            if(t == null){
                i+=2;
                continue;
            } else {
                final Integer intL = i+1 < size ? nodes.get(i+1) : null;
                final Integer intR = i+2 < size ? nodes.get(i+2) : null;
                final TreeNode childL = intL != null ? new TreeNode(intL, null, null) : null;
                final TreeNode childR = intR != null ? new TreeNode(intR, null, null) : null;
                t.left = childL; 
                t.right = childR;
                queue.add(childL);
                queue.add(childR);
                i+=2;
            }
        }
        return root;
    }
    /* ********************************************************************* */
    TreeNode decompressTree3(final String str) {return decompressTree3(str.split(","),0);}
    private TreeNode decompressTree3(final String[] nodes, final int INDEX){
        if(INDEX >= nodes.length) return null;
        if(nodes[INDEX].equals("*")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[INDEX]), null, null);
        root.left = decompressTree3(nodes,INDEX*2 + 1);
        root.right = decompressTree3(nodes, INDEX*2 + 2);
        return root;
    }
}
