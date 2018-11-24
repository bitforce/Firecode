package source.lvl2.p30;

import source.support.datastructure.node.ListNode;

class Source {
    ListNode deleteAtTail(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode tail = head;    
        while(tail.next.next != head) tail = tail.next;
        return tail.next = tail.next.next; 
    }
}
