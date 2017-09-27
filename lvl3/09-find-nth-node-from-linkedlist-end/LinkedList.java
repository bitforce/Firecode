import java.util.*;

class LinkedList {
    private static ListNode head;
    /* ********************************************************************* */
    private ListNode findNthNodeFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return null;
        ListNode node = head;
        int len = 1;
        while(node.next != null) {
            node = node.next;
            len++;
        }
        if(n > len) return null;
        node = head;
        for(int  i = 0; node != null && i < len-n; i++)
            node = node.next;
        return node;
    }
    /* ********************************************************************* */
    private void append(int data) {
        ListNode node = new ListNode(data);
        if(head == null) head = node;
        else {
            ListNode temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    private void print() {
        if(head == null)
            System.out.println("[X]");
        else {
            ListNode temp = head;
            while(temp.next != null) {
                System.out.print("[" + temp.data + "] --> ");
                temp = temp.next;
            }
            System.out.print("[" + temp.data + "] --> [X]\n");
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i = 0; i < args.length-1; i++)
            list.append(Integer.parseInt(args[i+1]));
        list.print();
        System.out.println(list.findNthNodeFromEnd(head, Integer.parseInt(args[0])).data); 
    }
    
    private class ListNode {
        int data;
        ListNode next;        
        ListNode(int data) { this.data = data; }
     }
}
