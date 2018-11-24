package source.lvl3.p08;

import source.support.datastructure.list.DoublyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final DoublyLinkedList list = new DoublyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().insertAtHead(list.head, Integer.parseInt(args[0]));
        list.print();
    }
}
