package source.lvl3.p05;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private ListNode insertAtPosition(ListNode head, int data, int pos) {
        ListNode node = new ListNode(data);
        if(head == null) return node;
        if(pos == 1) return head = node.next = head;
        ListNode temp = head;
        for(int i = 0; i < pos-2; i++)
            temp = temp.next;
        ListNode curr = temp.next;
        node.next = curr;
        temp.next = node;
        return head;
    }
    /* ********************************************************************* */
    private ListNode insertAtPosition2(ListNode head, int data, int pos) {
        if(head == null) return new ListNode(data);
        if(pos == 1) {
            ListNode node = new ListNode(data);
            node.next = head;
            return node;
        }
        head.next = insertAtPosition2(head.next, data, pos-1);
        return head;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 1; i < args.length-1; i++)
            list.append(Integer.parseInt(args[i+1]));
        list.print();
        final int DATA = Integer.parseInt(args[0]);
        final int POS = Integer.parseInt(args[1]);
        list.head = new Source().insertAtPosition(list.head, DATA, POS);
        list.head = new Source().insertAtPosition2(list.head, DATA+1, POS+1);
        list.print();
    } 
}
