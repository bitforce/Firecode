package source.lvl1.p05;

import source.temp.list.SinglyLinkedList;

public class SourceMain {
     public static void main (String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (String arg : args) list.append(Integer.parseInt(arg));
        list.print();
        System.out.println(new Source().findMiddleNode(list.head).data);
        System.out.println(new Source().findMiddleNode2(list.head).data);
    }
}
