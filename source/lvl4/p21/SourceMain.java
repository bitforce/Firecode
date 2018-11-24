package source.lvl4.p21;

import source.support.datastructure.list.CircularlyLinkedList;
import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
    public static void main(String[] args) {
        final CircularlyLinkedList clist = new CircularlyLinkedList();
        final SinglyLinkedList slist = new SinglyLinkedList();
        for (String arg : args) {
            clist.append(Integer.parseInt(arg));
            slist.append(Integer.parseInt(arg));
        }
        clist.print();
        slist.print();
        System.out.println(new Source().isCyclic(clist.head));
        System.out.println(new Source().isCyclic(slist.head));
    }
}
