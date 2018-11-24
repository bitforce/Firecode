package source.lvl3.p27;

import source.support.datastructure.node.DoublyListNode;

class Source {
    DoublyListNode deleteAtPos(final DoublyListNode head, final int POS) {
        if(head == null || POS < 1) return head;
        if(POS == 1) return head.next;
        DoublyListNode curr = head;
        DoublyListNode prev = null;
        for(int i = 0; curr != null && i < POS-1; i++) {
            prev = curr;
            curr = curr.next;
        }
        if(curr == null) return head;
        if(curr.next != null) {
            prev.next = curr.next;
            curr.next.prev = prev;
        } else prev.next = null;
        return head;
    }
    /* ********************************************************************* */
    DoublyListNode deleteAtPos2(final DoublyListNode head, final int POS) {
        if(head == null) return null;
        if(head.next == null) return POS == 1 ? null : head;
        DoublyListNode curr = head;
        DoublyListNode prev = null;
        int count = 1;
        while(curr != null) {
            if(count == POS) break;
            count++;
            prev = curr;
            curr = curr.next;
        }
        if(count < POS) return head;
        if(curr.next == null) {
            prev.next = null;
            curr.prev = null;
            return head;
        }
        if(count == 1) {
            DoublyListNode temp = curr;
            curr.next.prev = null;
            curr = curr.next;
            temp.next = null;
            return curr;
        }
        prev.next = curr.next;
        curr.prev = null;
        curr.next.prev = prev;
        curr.next = null;
        return head;
    }
}
