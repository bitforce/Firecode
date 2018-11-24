package source.lvl2.p26;

import source.support.datastructure.list.SinglyLinkedList;
import source.support.datastructure.node.ListNode;

class Source {
    ListNode deleteAtMiddle(ListNode head, int position) {  // N.1
        if(head == null || position < 1) return head;
        if(position == 1) return head.next;
        ListNode node = head;
        int length = 1;
        while(node.next != null) {
            length += 1;
            node = node.next;
        }
        if(position > length) return head;
        node = head;
        for(int i = 2; i < position; i++)
            node = node.next;
        node.next = node.next.next;
        return head;
    }
    /* ********************************************************************* */
    ListNode deleteAtMiddle2(ListNode head, int position) { // N.2
        if (position == 1)
            return head == null ? head : head.next;
        ListNode curr = head;
        ListNode prevNode = curr;
        int count = 0;
        while(curr != null) {
            count++;
            if(count == position) {
                prevNode.next = curr.next;
                curr.next = null;
            } 
            else {
                prevNode = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    /* ********************************************************************* */
    ListNode deleteAtMiddle3(ListNode head, int position) { // N.3
        if (head == null) {return null;}
        if (position == 1) {return head.next;}
        ListNode node = new ListNode(head.data);
        node.next = deleteAtMiddle(head.next, position-1);
        return node;
    }
}
