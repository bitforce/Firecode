package source.lvl4.p21;

import source.support.datastructure.node.ListNode;

class Source {
    boolean isCyclic(final ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
