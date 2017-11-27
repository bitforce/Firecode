package source.lvl4.p01;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode node = null;
        if(l1.data <= l2.data) {
            node = l1;
            node.next = mergeTwoSortedList(l1.next, l2);
        } else {
            node = l2;
            node.next = mergeTwoSortedList(l1, l2.next);
        }
        return node;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList l1 = new SinglyLinkedList();
        SinglyLinkedList l2 = new SinglyLinkedList();
        for(int i = 0; i < args.length/2; i++)
            l1.append(Integer.parseInt(args[i]));
        for(int i = args.length/2; i < args.length; i++)
            l2.append(Integer.parseInt(args[i]));
        l1.print();
        l2.print();
        list.head = new Source().mergeTwoSortedList(l1.head, l2.head);
        list.print();

    }
}
