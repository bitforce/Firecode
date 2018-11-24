package source.lvl3.p05;

import source.support.datastructure.node.ListNode;

class Source {
    ListNode insertAtPosition(ListNode head, final int data, final int pos) {
        final ListNode node = new ListNode(data);
        if(head == null) return node;
        if(pos == 1) return node.next = head;
        ListNode temp = head;
        for(int i = 0; i < pos-2; i++)
            temp = temp.next;
        ListNode curr = temp.next;
        node.next = curr;
        temp.next = node;
        return head;
    }
    /* ********************************************************************* */
    ListNode insertAtPosition2(ListNode head, int data, int pos) {
        if(head == null) return new ListNode(data);
        if(pos == 1) {
            ListNode node = new ListNode(data);
            node.next = head;
            return node;
        }
        head.next = insertAtPosition2(head.next, data, pos-1);
        return head;
    }
}
