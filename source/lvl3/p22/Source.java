package source.lvl3.p22;

import source.support.datastructure.node.DoublyListNode;

class Source {
    DoublyListNode insertAtPos(final DoublyListNode head, final int data, final int pos) {
        final DoublyListNode node = new DoublyListNode(data);
        if(head == null && pos < 1) return node;
        if(pos == 1) {
            node.next = head;
            return node;
        }
        DoublyListNode temp = head;
        int count = 0;
        for(int i = 1; temp != null && i < pos-1; i++) temp = temp.next;
        if(temp == null) return head;
        node.next = temp.next;
        temp.next = node;
        return head;
    }
    /* ********************************************************************* */
    DoublyListNode insertAtPos2(DoublyListNode head, final int data, final int pos) {
        final DoublyListNode node = new DoublyListNode(data);
        if(head == null && pos == 1) head = node;
        else {
            DoublyListNode curr = head;
            DoublyListNode prev = head;
            int count = 1;
            while(curr != null) {
                if(count == pos) break;
                else {
                    prev = curr;
                    curr = curr.next;
                    count++;
                }
            }
            if(count < pos) return head;
            if(count == 1) {
                node.next = curr;
                curr.prev = node;
                head = node;
            } else if(curr != null) {
                node.next = curr;
                node.prev = prev;
                prev.next = node;
                curr.prev = node;
            } else {
                prev.next = node;
                node.prev = prev;
            }
        }
        return head;
    }
    /* ********************************************************************* */
    DoublyListNode insertAtPos3(DoublyListNode head, final int data, final int pos) {
        if(pos <= 1) {
            final DoublyListNode node = new DoublyListNode(data);
            if(head != null) {
                node.next = head;
                node.prev = head.prev;
                head.prev = node;
            }
            head = node;
        } else if(head != null) head.next = insertAtPos3(head.next, data, pos-1);
        return head;
    }
}
