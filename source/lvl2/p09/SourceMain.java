package source.lvl2.p09;

import source.support.datastructure.list.CircularlyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final CircularlyLinkedList list = new CircularlyLinkedList();
        for (String arg : args) list.append(Integer.parseInt(arg));
        list.print();
        list.head = new Source().deleteAtHead(list.head);
        list.print();
        list.head = new Source().deleteAtHead2(list.head);
        list.print();
        list.head = new Source().deleteAtHead3(list.head);
        list.print();
        list.head = new Source().deleteAtHead4(list.head);
        list.print();
    }
}
