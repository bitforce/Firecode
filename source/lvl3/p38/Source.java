package source.lvl3.p38;

import source.support.datastructure.list.SinglyLinkedList;
import source.support.datastructure.node.ListNode;

class Source {
    ListNode findNthNodeFromEnd(final ListNode head, final int n) {
        if(head == null || n < 1) return null;
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        if(n > len) return null;
        final int LEN = len - n;
        temp = head;
        for(int i = 0; i < LEN; i++)
            temp = temp.next;
        return temp;
    }
    /* ********************************************************************* */
    ListNode findNthNodeFromEnd2(ListNode head, int n) {
        ListNode node = head;
        int len = 0;
        while(node != null) {
            node = node.next;
            len++;
        }
        final int POS = len - n + 1;
        int count = 0;
        node = head;
        while(node != null) {
            count++;
            if(count == POS)
                break;
            node = node.next;
        }
        return node;
    }
    /* ********************************************************************* */
    ListNode findNthNodeFromEnd3(final ListNode head, int n) {
        if(head == null || n <= 0) return null;
        ListNode fast = head;
        ListNode slow = null;
        while(fast != null) {
            fast = fast.next;
            if(n > 1) {
                n -= 1;
            } else if(n == 1) {
                slow = head;
                n -= 1;
            } else {
                assert slow != null;
                slow = slow.next;
            }
        }
        return slow;
    }
}
