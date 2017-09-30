package source.temp.help;
import source.temp.node.TreeNode;
import java.util.*;
public class TreePrinter {
    public static void print(TreeNode root) {
        int max = TreePrinter.max(root);
        internal(Collections.singletonList(root), 1, max);
    }
    private static void internal(List<TreeNode> nodes, int level, int max) {
        if (nodes.isEmpty() || TreePrinter.leafless(nodes)) return;
        int floor = max - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
        TreePrinter.whitespaces(firstSpaces);
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                list.add(node.left);
                list.add(node.right);
            } else {
                list.add(null);
                list.add(null);
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
        internal(list, level + 1, max);
    }
    private static void whitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }
    private static int max(TreeNode node) {
        if (node == null) return 0;
        return Math.max(TreePrinter.max(node.left), TreePrinter.max(node.right)) + 1;
    }
    private static boolean leafless(List<TreeNode> list) {
        for (Object object : list)
            if (object != null)
                return false;
        return true;
    }
}
