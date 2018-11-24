package source.lvl2.p01;

import source.support.datastructure.node.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

class Source {
    ArrayList<Integer> preorderItr(TreeNode root) {
        final ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            list.add(node.data);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return list;
    }
}
