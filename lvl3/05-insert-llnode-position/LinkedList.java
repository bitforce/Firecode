import java.util.*;

class LinkedList {
    private static ListNode head;
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
    private void append(int data) {
        ListNode node = new ListNode(data);
        if(head != null) {
            ListNode temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        } else head = node;
    }
    @Override
    public String toString() {
        String s = "";
        if(head == null) s = "[X]";
        else {
            ListNode temp = head;
            while(temp.next != null) {
                s += "[" + temp.data + "] --> ";
                temp = temp.next;
            }
            s += "[" + temp.data + "] --> *\n";
        }
        System.out.print(s);
        return s;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i = 1; i < args.length-1; i++)
            list.append(Integer.parseInt(args[i+1]));
        list.toString();
        int data = Integer.parseInt(args[0]);
        int pos = Integer.parseInt(args[1]);
        if(pos < 1) head = null;
        head = list.insertAtPosition(head, data, pos);
        head = list.insertAtPosition2(head, data+1, pos+1);
        list.toString();
    } 
    private class ListNode {
        int data;
        ListNode next;        
        ListNode(int data) { this.data = data; }
     }
}
