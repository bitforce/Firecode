package source.lvl3.p05;

import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 1; i < args.length-1; i++)
            list.append(Integer.parseInt(args[i+1]));
        list.print();
        final int DATA = Integer.parseInt(args[0]);
        final int POS = Integer.parseInt(args[1]);
        list.head = new Source().insertAtPosition(list.head, DATA, POS);
        list.head = new Source().insertAtPosition2(list.head, DATA+1, POS+1);
        list.print();
    }
}
