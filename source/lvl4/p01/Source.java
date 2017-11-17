package source.lvl4.p01;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null && l2 != null) return l2;
        if(l1 != null && l2 == null) return l1;
        // MERGE RECURSIVELY
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList l1 = new SinglyLinkedList();
        SinglyLinkedList l2 = new SinglyLinkedList();
        for(int i = 0; i < args.length/2; i++)
            l1.add(Integer.parseInt(args[i]));
        for(int i = args.length/2; i < args.length; i++)
            l2.add(Integer.parseInt(args[i]));
        l1.print();
        l2.print();
        list.head = new Source().mergeTwoSortedList(l1, l2);
        list.print();

    }
}
