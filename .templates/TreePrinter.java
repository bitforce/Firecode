import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// NOTE : THIS IS EXPERIMENTAL AND NOT READY FOR IMPLEMENTATION
class TreePrinter {
    public static <T extends Comparable<?>> void printNode(TreeNode<T> root) {
        int maxLevel = TreePrinter.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void 
        printNodeInternal(List<TreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || TreePrinter.checkNullElements(nodes))
            return;
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
        TreePrinter.whitespaces(firstSpaces);
        List<TreeNode<T>> newNodes = new ArrayList<TreeNode<T>>();
        for (TreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            TreePrinter.whitespaces(betweenSpaces);
        }
        System.out.println("");
        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                TreePrinter.whitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    TreePrinter.whitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }
                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    TreePrinter.whitespaces(1);
                TreePrinter.whitespaces(i + i - 1);
                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    TreePrinter.whitespaces(1);
                TreePrinter.whitespaces(endgeLines + endgeLines - i);
            }
            System.out.println("");
        }
        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void whitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode<T> node) {
        if (node == null) return 0;
        return Math.max(TreePrinter.maxLevel(node.left), 
                TreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean checkNullElements(List<T> list) {
        for (Object object : list)
            if (object != null)
                return false;
        return true;
    }

    private class TreeNode<T> {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {this.data = data;}
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
