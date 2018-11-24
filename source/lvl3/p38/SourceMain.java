package source.lvl3.p38;

import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        final int n = Integer.parseInt(args[0]);
        System.out.println(new Source().findNthNodeFromEnd(list.head, n).data);
        System.out.println(new Source().findNthNodeFromEnd2(list.head, n).data);
        System.out.println(new Source().findNthNodeFromEnd3(list.head, n).data);
    }
}
