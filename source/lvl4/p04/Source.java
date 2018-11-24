package source.lvl4.p04;

import source.support.datastructure.node.ListNode;

class Source {
    ListNode reverseInPairs(final ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            int i = temp.data;
            temp.data = temp.next.data;
            temp.next.data = i;
            temp = temp.next.next;
        }
        return head;
    }
    /* ********************************************************************* */
    ListNode reverseInPairs2(final ListNode head) {
        if(head == null || head.next == null) return head;
        final ListNode a = head.next;
        final ListNode b = head.next.next;
        a.next = head;
        head.next = b == null ? null : this.reverseInPairs2(b);
        return a;
    }
}
