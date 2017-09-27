import java.util.*;

class LinkedList {
    private static ListNode head;
    
    private void append(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
            head.next = node;
            node = head;
            return;
        }
        ListNode tail = head;
        while(tail.next != head)
           tail = tail.next; 
        tail.next = node;
        tail = node;
        tail.next = head;
    }

    private void print() {
        if(head == null)
            System.out.println("[X]");
        else {
            ListNode temp = head;
            while(temp.next != head) {
                System.out.print("[" + temp.data + "] --> ");
                temp = temp.next;
            }
            System.out.print("[" + temp.data + "] --> *\n");
        }
    }
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        for(int i = 0; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
    }
    
    private class ListNode {
        int data;
        ListNode next;        
        ListNode(int data) { this.data = data; }
     }
}
