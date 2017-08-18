import java.util.*;
class CLL {
    private static ListNode head;
   /* ********************************************************************** */ 
    private ListNode deleteAtTail(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode tail = head;    
        while(tail.next.next != head) tail = tail.next;
        return tail.next = tail.next.next; 
    }
   /* ********************************************************************** */ 
    private void append(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
            head.next = node;
            node = head;
            return;
        }
        ListNode tail = head;
        while(tail.next != head) tail = tail.next; 
        tail.next = node;
        tail = node;
        tail.next = head;
    }

    private void print() {
        if(head == null) System.out.println("[X]");
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
        CLL list = new CLL();
        for(int i = 0; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        head = list.deleteAtTail(head);
        list.print();
    }
    private class ListNode {
        int data;
        ListNode next;        
        ListNode(int data) { this.data = data; }
     }
}
