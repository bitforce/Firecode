package source.lvl3.p01;

import source.support.datastructure.node.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

class Source {
    ArrayList<Integer> ancestorsList = new ArrayList<>();
    boolean printAncestors(TreeNode root, int nodeData) {
        if(root == null) return false;
        if(root.data == nodeData) return true;       
        if (printAncestors(root.left, nodeData) 
                || printAncestors(root.right, nodeData)) {
            ancestorsList.add(root.data);
            return true;
        }
        return false;
    }
    /* ********************************************************************* */
    ArrayList<Integer> ancestorsList2 = new ArrayList<>();
    boolean printAncestors2(TreeNode root, int nodeData) {
        if(root == null) return false;
        final Stack<TreeNode> stack = new Stack<>();
        while(true) {
            while(root != null && root.data != nodeData) {
                stack.push(root);
                root = root.left;
            }
            if(root != null) break;
            if(stack.peek().right == null) {
                root =stack.peek();
                stack.pop();
                while(!stack.empty() && stack.peek().right == root) {
                    root = stack.peek();
                    stack.pop();
                }
            }
            root = stack.empty() ? null : stack.peek().right;
        }
        while(!stack.empty()) {
            ancestorsList2.add(stack.peek().data);
            stack.pop();
        }
        return true;
    }
}
