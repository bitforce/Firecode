package source.lvl1.p15;

import source.temp.node.ListNode;

class Source {
    ListNode insertAtHead(ListNode head, int data) {
        if(head == null) return new ListNode(data);
        ListNode temp = new ListNode(data);
        temp.next = head;
        return head = temp;
    }
    /* ********************************************************************* */
    ListNode insertAtHead2(ListNode head, int data) {
        ListNode temp = new ListNode(data);
        temp.next = head;
        return temp;
    }
}
