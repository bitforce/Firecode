package source.lvl2.p26;

import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[0]);
        Source obj = new Source();
        list.print();
        list.head = obj.deleteAtMiddle(list.head, N);
        list.print();
        list.head = obj.deleteAtMiddle2(list.head, N);
        list.print();
        list.head = obj.deleteAtMiddle3(list.head, N);
        list.print();
    }
}
