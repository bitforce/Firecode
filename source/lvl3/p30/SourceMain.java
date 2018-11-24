package source.lvl3.p30;

import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().removeNthFromEnd(list.head, Integer.parseInt(args[0]));
        list.print();
        list.head = new Source().removeNthFromEnd2(list.head, Integer.parseInt(args[0]));
        list.print();
        list.head = new Source().removeNthFromEnd3(list.head, Integer.parseInt(args[0]));
        list.print();
    }
}
