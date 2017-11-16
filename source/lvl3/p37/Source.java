package source.lvl3.p37;
import source.temp.list.CircularlyLinkedList;
import source.temp.node.ListNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private ListNode insertAtTail(ListNode head, int data) {
        if(head == null) {
            head = new ListNode(data);
            return head.next = head;
        }
        ListNode node = head;
        while(node.next != null && node.next != head)
            node = node.next;
        ListNode temp = new ListNode(data);
        node.next = temp;
        temp.next = head;
        return head;
    }
    /* ********************************************************************* */
    private ListNode insertAtTail2(ListNode head, int data) {
        ListNode node = new ListNode(data);
        ListNode curr = head;
        if(head == null) {
            head = node;
        } else {
            while(curr.next != head)
                curr = curr.next;
            node.next = head;
            curr.next = node;
        }
        return head;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        final int DATA = Integer.parseInt(args[0]);
        list.head = new Source().insertAtTail(list.head, DATA);
        list.print();
    }
}
