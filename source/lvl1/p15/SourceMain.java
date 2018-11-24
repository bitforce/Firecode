package source.lvl1.p15;

import source.temp.list.SinglyLinkedList;

public class SourceMain {
     public static void main (String[] args) {
        final SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < args.length-1; i++)
            list.append(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[args.length-1]);
        list.print();
        list.head = new Source().insertAtHead(list.head, N);
        list.print();
        list.head = new Source().insertAtHead2(list.head, N);
        list.print();
    }
}
