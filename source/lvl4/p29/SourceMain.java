package source.lvl4.p29;

import source.support.datastructure.list.SinglyLinkedList;
import source.support.datastructure.node.ListNode;

import static source.lvl4.p29.Source.sumTwoLinkedLists;

public class SourceMain {
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        for(int i = 1; i < args.length; i++) {
            if(i < Integer.parseInt(args[0]) + 1) list1.append(Integer.parseInt(args[i]));
            else list2.append(Integer.parseInt(args[i]));
        }
        list1.print();
        list2.print();
        ListNode node = sumTwoLinkedLists(list1.head, list2.head);
        while(node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("[X]");
    }
}
