package source.lvl1.p16;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
class Source {
    /* ********************************************************************* */
    private ListNode deleteAtHead(ListNode head) {
        if (head == null)
            return null;
        return head = head.next;
    }
    /* ********************************************************************* */
    private ListNode deleteAtHead2(ListNode head) {
        return (head != null) ? head.next : null;
    }
    /* ********************************************************************* */
    public static void main (String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < args.length; i++) 
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().deleteAtHead(list.head);
        list.print();
        list.head = new Source().deleteAtHead2(list.head);
        list.print();
    }
}
