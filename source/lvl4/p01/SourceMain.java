package source.lvl4.p01;

import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final SinglyLinkedList list = new SinglyLinkedList();
        final SinglyLinkedList l1 = new SinglyLinkedList();
        final SinglyLinkedList l2 = new SinglyLinkedList();
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
