package templates.list;
import templates.node.DoublyListNode;
public class DoublyLinkedList {
    public DoublyListNode head;
    public void clear() {head = null;}
    public void print() {System.out.print(toString());}
    public void append(int data) {
        DoublyListNode node = new DoublyListNode(data);
        if(head != null) {
            DoublyListNode last = head;
            while(last.next != null)
                last = last.next;
            last.next = node;
            node.prev = last;
        } else {
            head = node;
        }
    }
    public String toString() {
        String s = "";
        if(head != null) {
            DoublyListNode temp = head;
            while(temp.next != null) {
                s += "[" + temp.data + "] <-> ";
                temp = temp.next;
            }
            s += "[" + temp.data + "] --> X\n";
        } else s = "[X]\n";
        return s;
    }
}
