package source.lvl1.p03;

import source.support.datastructure.list.SinglyLinkedList;

class SourceMain {
    public static void main (String[] args) {
        final SinglyLinkedList list = new SinglyLinkedList();
        for (String s : args) 
            list.append(Integer.parseInt(s));
        list.print();
        list.head = new Source().deleteAtTail(list.head);
        list.print();
    }
}
