package source.lvl2.p27;

import source.support.datastructure.node.ListNode;

class Source {
    boolean isListEven(ListNode head) {
        if(head == null) return true;
        ListNode node = head;
        int counter = 0;
        while(node != null) {
            counter++;
            node = node.next;
        }
        return counter % 2 == 0;
    }
    /* ********************************************************************* */
    boolean isListEven2(ListNode head) {
        boolean even = true;
        while(head != null) {
            even = !even;
            head = head.next;
        } 
        return even;
    }
}
