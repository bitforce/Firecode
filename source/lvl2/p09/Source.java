package source.lvl2.p09;

import source.support.datastructure.node.ListNode;

class Source {
    ListNode deleteAtHead(ListNode head) {
        if(head == null || head.next == head) return null;
        ListNode tail = head;
        while(tail.next != head)
            tail = tail.next;
        head = head.next;
        tail.next = head;
        return head;
    }
   /* ********************************************************************** */ 
    ListNode deleteAtHead2(ListNode head) {
        if (head == null) return null;
        ListNode tail = head;
        while(tail.next != head)
            tail = tail.next;
        tail.next = head.next;        
        head.next = null;
        head = tail.next;
        return head;
    }
   /* ********************************************************************** */ 
    ListNode deleteAtHead3(ListNode head) {
        if (head == null || head.next == head) return null;
        head.data = head.next.data;
        return head.next = head.next.next;
    }
   /* ********************************************************************** */ 
    ListNode deleteAtHead4(ListNode head) {
        if (head == null || head.next == head) return null; 
        ListNode tail = head;
        while (tail.next != head)
            tail = tail.next;
        return tail.next = head.next;
    }
}
