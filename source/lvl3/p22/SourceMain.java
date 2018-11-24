package source.lvl3.p22;

import source.support.datastructure.list.DoublyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final DoublyLinkedList list = new DoublyLinkedList();
        for(int i = 2; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        int data = Integer.parseInt(args[0]);
        int pos = Integer.parseInt(args[1]);
        list.print();
        list.head = new Source().insertAtPos(list.head, data, pos);
        list.print();
        list.head = new Source().insertAtPos2(list.head, data, pos);
        list.print();
        list.head = new Source().insertAtPos3(list.head, data, pos);
        list.print();
    }
}
