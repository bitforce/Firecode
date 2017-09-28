package templates;
import templates.ListNode;
public class CircularlyLinkedList {
    public ListNode head;
    public void clear() {head = null;}
    public void print() {System.out.print(toString());}
    public void append(int data) {
        ListNode node = new ListNode(data);
        if(head != null) {
            ListNode tail = head;
            while(tail.next != head)
                tail = tail.next;
            tail.next = node;
            tail = node;
            tail.next = head;
        } else {
            head = node;
            head.next = node;
            node = head;
        }
    }
    @Override
    public String toString() {
        String s = "";
        if(head != null) {
            ListNode temp = head;
            while(temp.next != head) {
                s += "[" + temp.data + "] --> ";
                temp = temp.next;
            }
            s += "[" + temp.data + "] --> *\n";
        } else s = "[X]\n";
        return s;
    }
}
