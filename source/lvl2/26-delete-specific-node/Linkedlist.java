import java.util.*;
class Linkedlist {
    private static ListNode head;
    private static Linkedlist list;
    Linkedlist() {}
    Linkedlist(int data) {head = new ListNode(data);}
    /* ********************************************************************* */
    private ListNode deleteAtMiddle(ListNode head, int position) {  // N.1
        if(head == null || position < 1) return head;
        if(position == 1) return head.next;
        ListNode node = head;
        int length = 1;
        while(node.next != null) {
            length += 1;
            node = node.next;
        }
        if(position > length) return head;
        node = head;
        for(int i = 2; i < position; i++)
            node = node.next;
        node.next = node.next.next;
        return head;
    }
    private ListNode deleteAtMiddle2(ListNode head, int position) { // N.2
        if (position == 1)
            return head == null ? head : head.next;
        ListNode curr = head;
        ListNode prevNode = curr;
        int count = 0;
        while(curr != null) {
            count++;
            if(count == position) {
                prevNode.next = curr.next;
                curr.next = null;
            } 
            else {
                prevNode = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    private ListNode deleteAtMiddle3(ListNode head, int position) { // N.3
        if (head == null) {return null;}
        if (position == 1) {return head.next;}
        ListNode node = new ListNode(head.data);
        node.next = deleteAtMiddle(head.next, position-1);
        return node;
    }
    /* ********************************************************************* */
    private ListNode append (int data, ListNode head) {
        if (head == null)
            return head = new ListNode(data);
        ListNode node = new ListNode(data);
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
        head = temp;
        return head;
    }
    private void print() {
        if (head == null) {
            System.out.println("NULL");
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print("[" + temp.data + "] --> ");
            temp = temp.next;
        }
        System.out.print("[X]\n");
    }
    public static void main(String[] args) {
        list = new Linkedlist(Integer.parseInt(args[1]));
        for(int i = 2; i < args.length; i++)
            list.append(Integer.parseInt(args[i]), head);
        list.print();
        head = list.deleteAtMiddle(head, Integer.parseInt(args[0]));
        list.print();
        head = list.deleteAtMiddle2(head, Integer.parseInt(args[0]));
        list.print();
        head = list.deleteAtMiddle3(head, Integer.parseInt(args[0]));
        list.print();
    }
    private class ListNode {
        int data;
        ListNode next;        
        ListNode(int data) { this.data = data; }
     }
}
