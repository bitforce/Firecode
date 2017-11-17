package source.lvl1.p15;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
class Source {
    /* ********************************************************************* */
    private ListNode insertAtHead(ListNode head, int data) {
        if(head == null) return new ListNode(data);
        ListNode temp = new ListNode(data);
        temp.next = head;
        return head = temp;
    }
    /* ********************************************************************* */
    private ListNode insertAtHead2(ListNode head, int data) {
        ListNode temp = new ListNode(data);
        temp.next = head;
        return temp;
    }
    /* ********************************************************************* */
    public static void main (String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < args.length-1; i++) 
            list.append(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[args.length-1]);
        list.print();
        list.head = new Source().insertAtHead(list.head, N);
        list.print();
    }
}
