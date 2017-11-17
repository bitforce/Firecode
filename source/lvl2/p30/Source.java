package source.lvl2.p30;
import source.temp.list.CircularlyLinkedList;
import source.temp.node.ListNode;
class Source {
   /* ********************************************************************** */ 
    private ListNode deleteAtTail(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode tail = head;    
        while(tail.next.next != head) tail = tail.next;
        return tail.next = tail.next.next; 
    }
   /* ********************************************************************** */ 
    public static void main(String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();
        for(int i = 0; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().deleteAtTail(list.head);
        list.print();
    }
}
