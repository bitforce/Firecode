package source.lvl4.p01;

import source.support.datastructure.node.ListNode;

class Source {
    ListNode mergeTwoSortedList(final ListNode l1, final ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode node = null;
        if(l1.data <= l2.data) {
            node = l1;
            node.next = mergeTwoSortedList(l1.next, l2);
        } else {
            node = l2;
            node.next = mergeTwoSortedList(l1, l2.next);
        }
        return node;
    }
}
