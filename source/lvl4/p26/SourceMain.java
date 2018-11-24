package source.lvl4.p26;

import source.support.datastructure.list.SinglyLinkedList;
import source.support.datastructure.node.ListNode;

import java.util.ArrayList;

public class SourceMain {
    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<>();
        int numberOfLists = Integer.parseInt(args[0]);
		int k = 0;
        for(int i = 0; i < numberOfLists; i++) {
            SinglyLinkedList list = new SinglyLinkedList();
            for(int j = 0; j < Integer.parseInt(args[i+1]); j++) {
                list.append(Integer.parseInt(args[numberOfLists+i+k+1]));
                k++;
            }
            k--;
            lists.add(list.head);
            list.print();
        }
        // NOTE - both methods do give the correct answer, but running them
        // sequentially forces a infinite recursive call and I can't tell
        // if the problem stems from a code-related issue or if my
        // computer is being retarded with it's object pool mgmt

        print(new Source().mergeKLists(lists));
        print(new Source().mergeKLists2(lists));
        print(new Source().mergeKLists3(lists));
    }
    private static void print(ListNode head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("[X]");
        System.out.println();
    }
}
