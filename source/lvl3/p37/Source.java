package source.lvl3.p37;

import source.support.datastructure.node.ListNode;

class Source {
    ListNode insertAtTail(ListNode head, final int DATA) {
        if(head == null) {
            head = new ListNode(DATA);
            return head.next = head;
        }
        ListNode node = head;
        while(node.next != null && node.next != head)
            node = node.next;
        final ListNode temp = new ListNode(DATA);
        node.next = temp;
        temp.next = head;
        return head;
    }
    /* ********************************************************************* */
    ListNode insertAtTail2(ListNode head, final int DATA) {
        ListNode node = new ListNode(DATA);
        ListNode curr = head;
        if(head == null) {
            head = node;
        } else {
            while(curr.next != head)
                curr = curr.next;
            node.next = head;
            curr.next = node;
        }
        return head;
    }
}
