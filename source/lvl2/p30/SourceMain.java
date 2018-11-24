package source.lvl2.p30;

import source.support.datastructure.list.CircularlyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final CircularlyLinkedList list = new CircularlyLinkedList();
        for(int i = 0; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().deleteAtTail(list.head);
        list.print();
    }
}
