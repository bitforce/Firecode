package source.lvl3.p16;

import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        SinglyLinkedList sll2 = new SinglyLinkedList();
        SinglyLinkedList sll3 = new SinglyLinkedList();
         for (String arg : args) {
             sll1.append(Integer.parseInt(arg));
             sll2.append(Integer.parseInt(arg));
             sll3.append(Integer.parseInt(arg));
         }
        sll1.print();
        sll1.head = new Source().removeDuplicates(sll1.head);
        sll1.print();
        sll2.print();
        sll2.head = new Source().removeDuplicates2(sll2.head);
        sll2.print();
        sll3.print();
        sll3.head = new Source().removeDuplicates3(sll3.head);
        sll3.print();
    }
}
