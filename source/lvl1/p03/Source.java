package source.lvl1.p03;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
class Source {
    /* ********************************************************************* */
    private ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode temp = head;
        while(temp.next.next != null)
            temp = temp.next;
        temp.next = null;
        return head;
    }
    /* ********************************************************************* */
    public static void main (String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < args.length; i++) 
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().deleteAtTail(list.head);
        list.print();
    }
}
