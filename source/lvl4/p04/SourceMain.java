package source.lvl4.p04;

import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 0; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().reverseInPairs(list.head);
        list.print();
        list.head = new Source().reverseInPairs2(list.head);
        list.print();
    }
}
