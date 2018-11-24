package source.lvl3.p29;

import source.support.datastructure.list.SinglyLinkedList;

public class SourceMain {
     public static void main(String[] args) {
        final SinglyLinkedList list = new SinglyLinkedList();
        for (String arg : args) list.append(Integer.parseInt(arg));
        list.print();
        System.out.println(new Source().isListPalindrome(list.head));
        System.out.println(new Source().isListPalindrome2(list.head));
        System.out.println(new Source().isListPalindrome3(list.head));
    }
}
