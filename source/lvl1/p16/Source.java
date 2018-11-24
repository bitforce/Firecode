package source.lvl1.p16;

import source.temp.node.ListNode;

class Source {
    ListNode deleteAtHead(ListNode head) {
        if (head == null)
            return null;
        return head = head.next;
    }
    /* ********************************************************************* */
    ListNode deleteAtHead2(ListNode head) {
        return (head != null) ? head.next : null;
    }
}
