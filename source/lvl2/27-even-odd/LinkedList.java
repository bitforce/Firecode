import java.util.*;
class Linkedlist {
    private static ListNode head;
    private static Linkedlist list;
    Linkedlist() {}
    Linkedlist(int data) {head = new ListNode(data);}
    /* ********************************************************************* */
    private boolean isListEven(ListNode head) {
        if(head == null) return true;
        ListNode node = head;
        int counter = 0;
        while(node != null) {
            counter++;
            node = node.next;
        }
        return counter % 2 == 0;
    }
    private boolean isListEven(ListNode head) { // BEST SOLUTION
        boolean even = true;
        while(head != null) {
            even = !even;
            head = head.next;
        } 
        return even;
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
        list = new Linkedlist(Integer.parseInt(args[0]));
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]), head);
        list.print();
        System.out.println(list.isListEven(head));
    }
    private class ListNode {
        int data;
        ListNode next;        
        ListNode(int data) { this.data = data; }
     }
}
