package source.lvl4.p04;
import source.support.datastructure.list.SinglyLinkedList;
import source.support.datastructure.node.ListNode;

class Source {
    /* ********************************************************************* */
    private ListNode reverseInPairs(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            int i = temp.data;
            temp.data = temp.next.data;
            temp.next.data = i;
            temp = temp.next.next;
        }
        return head;
    }
    /* ********************************************************************* */
    private ListNode reverseInPairs2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode a = head.next;
        ListNode b = head.next.next;
        a.next = head;
        head.next = b == null ? null : this.reverseInPairs2(b);
        return a;
    }
    /* ********************************************************************* */

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 0; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().reverseInPairs(list.head);
        list.print();
        list.head = new Source().reverseInPairs2(list.head);
        list.print();
    }
}
