package source.lvl3.p37;

import source.support.datastructure.list.CircularlyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final CircularlyLinkedList list = new CircularlyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        final int DATA = Integer.parseInt(args[0]);
        list.head = new Source().insertAtTail(list.head, DATA);
        list.print();
        list.head = new Source().insertAtTail2(list.head, DATA);
        list.print();
    }
}
