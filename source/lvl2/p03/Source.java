package source.lvl2.p03;

import source.support.datastructure.node.TreeNode;

import java.util.ArrayList;

class Source {
    final ArrayList<Integer> preorderedList = new ArrayList<>();
    void preorder(final TreeNode root) {
        if(root == null) return;
        preorderedList.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }
}
