package source.lvl3.p30;

import source.support.datastructure.node.ListNode;

class Source {
    ListNode removeNthFromEnd(final ListNode head, final int n) {
        if(head == null || n < 1) return head;
        ListNode node = head;
        int len = 0;
        while(node != null) {
            node = node.next;
            len++;
        }
        if(len < n) return head;
        if(len == n) return head.next;
        node = head;
        for(int i = 0; node != null && i < len-n-1; i++)
            node = node.next;
        if(node == null) return head;
        node.next = node.next.next;
        return head;
    }
    /* ********************************************************************* */
    ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        int length = 0;
        int nth = 0;
        int pos = 0;
        ListNode node = head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        nth = length - n + 1;
        curr = head;
        while(curr != null) {
            pos++;
            if(pos == nth) {
                if(pos == 1) {
                    head = curr.next;
                    curr.next = null;
                    node = head;
                }
                else if(pos == length)
                    prev.next = null;
                else {
                    prev.next = curr.next;
                    curr.next = null;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return node;
    }
    /* ********************************************************************* */
    ListNode removeNthFromEnd3(final ListNode head, int n) {
        if(head == null || n < 1) return head;
        ListNode prev = head;
        ListNode curr = head;
        while(curr.next != null) {
            if(--n < 0) prev = prev.next;
            curr = curr.next;
        }
        if(n <= 0) prev.next = prev.next.next;
        System.out.println(n);
        return n == 1 && curr.next == null ? head.next : head;
    }
}
