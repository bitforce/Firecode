package source.lvl2.p27;

import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final SinglyLinkedList list = new SinglyLinkedList();
        for (String arg : args) list.append(Integer.parseInt(arg));
        list.print();
        System.out.println(new Source().isListEven(list.head));
        System.out.println(new Source().isListEven2(list.head));
    }
}
