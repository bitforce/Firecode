package source.lvl3.p46;
import source.temp.tree.BinaryTree;
import source.temp.node.TreeNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private TreeNode decompressTree(String str) {
        if(str == null || str.equals("*") || str.startsWith("*")) return null;
        Queue<TreeNode> parents = new LinkedList<>();
        Queue<Integer> numbers = new LinkedList<>();
        for(String s : str.split(","))
            numbers.add("*".equals(s) ? null : Integer.parseInt(s));
        TreeNode root = new TreeNode(numbers.remove(), null, null);
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
    private TreeNode decompressTree2(String str){
        if(str == null || str.equals("") || str.equals("*")) return null;
        ArrayList<Integer> nodes = new ArrayList<>();
        String[] splits = str.split(",");
        for(String s: splits){
            Integer i = s.equals("*") ? null : Integer.valueOf(s);
            nodes.add(i);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int size = nodes.size();
        int i = 0;
        TreeNode root = new TreeNode(nodes.get(0), null, null);
        queue.add(root);
        while(i < nodes.size()){
            TreeNode t = queue.poll();
            if(t == null){
                i+=2;
                continue;
            } else {
                Integer intL = i+1 < size ? nodes.get(i+1) : null;
                Integer intR = i+2 < size ? nodes.get(i+2) : null;
                TreeNode childL = intL != null ? new TreeNode(intL, null, null) : null;
                TreeNode childR = intR != null ? new TreeNode(intR, null, null) : null;
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
    private TreeNode decompressTree3(String str) {return decompressTree3(str.split(","),0);}
    private TreeNode decompressTree3(String[] nodes, int index){
        if(index >= nodes.length) return null;
        if(nodes[index].equals("*")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index]), null, null);
        root.left = decompressTree3(nodes,index*2 + 1);
        root.right = decompressTree3(nodes, index*2 + 2);
        return root;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        String str = "";
        for(int i = 0; i < args.length; i++)
            if(i != args.length-1) str += args[i] + ",";
            else str += args[i];
        tree.root = new Source().decompressTree(str);
        tree.print();
        tree.root = new Source().decompressTree2(str);
        tree.print();
        tree.root = new Source().decompressTree3(str);
        tree.print();
    }
}
