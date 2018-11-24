package source.lvl3.p09;

import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[0]);
        list.print();
        System.out.println(new Source().findNthNodeFromEnd(list.head, N).data);
    }
}
