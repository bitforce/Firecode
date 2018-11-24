package source.lvl3.p32;

import source.support.datastructure.list.CircularlyLinkedList;
import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        CircularlyLinkedList cll = new CircularlyLinkedList();
        SinglyLinkedList sll = new SinglyLinkedList();
        for(int i = 0; i < args.length; i++) {
            sll.append(Integer.parseInt(args[i]));
            cll.append(Integer.parseInt(args[i]));
        }
        sll.print();
        System.out.println(new Source().isCyclic(sll.head));
        System.out.println(new Source().isCyclic2(sll.head));
        System.out.println(new Source().isCyclic3(sll.head));
        // CAN'T USE A CLL B/C IT WILL ALWAYS POINT BACK TO ITSELF
        cll.print();
        System.out.println(new Source().isCyclic(cll.head));
        System.out.println(new Source().isCyclic2(cll.head));
        System.out.println(new Source().isCyclic3(cll.head));
    }
}
