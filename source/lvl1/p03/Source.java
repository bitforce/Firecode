package source.lvl1.p03;

import source.support.datastructure.node.ListNode;

class Source {
    ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode temp = head;
        while(temp.next.next != null)
            temp = temp.next;
        temp.next = null;
        return head;
    }
}
