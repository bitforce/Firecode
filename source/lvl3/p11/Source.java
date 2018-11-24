package source.lvl3.p11;

import source.support.datastructure.node.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

class Source {
    ArrayList<Integer> inOrderItr(final TreeNode root) {
        final ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.empty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.data);
            node = node.right;
        }
        return list;
    }
}
