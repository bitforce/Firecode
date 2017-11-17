package source.lvl2.p09;
import source.temp.list.CircularlyLinkedList;
import source.temp.node.ListNode;
class Source {
   /* ********************************************************************** */ 
    private ListNode deleteAtHead(ListNode head) {
        if(head == null || head.next == head) return null;
        /* ********************* */
        ListNode tail = head;
        while(tail.next != head)
            tail = tail.next;
        /* ********************* */
        head = head.next;
        tail.next = head;
        return head;
    }
   /* ********************************************************************** */ 
    private ListNode deleteAtHead2(ListNode head) {
        if (head == null)
            return null;
        ListNode tail = head;
        while(tail.next != head)
            tail = tail.next;
        tail.next = head.next;        
        head.next = null;
        head = tail.next;
        return head;
    }
   /* ********************************************************************** */ 
    private ListNode deleteAtHead3(ListNode head) {
        if (head == null || head.next == head)
            return null;
        head.data = head.next.data;
        return head.next = head.next.next;
    }
   /* ********************************************************************** */ 
    private ListNode deleteAtHead4(ListNode head) {
        if (head == null || head.next == head) return null; 
        ListNode tail = head;
        while (tail.next != head)
            tail = tail.next;
        return tail.next = head.next;
    }
   /* ********************************************************************** */ 

    public static void main(String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();
        for(int i = 0; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().deleteAtHead(list.head);
        list.print();
//        list.head = new Source().deleteAtHead2(list.head);
//        list.print();
//        list.head = new Source().deleteAtHead3(list.head);
//        list.print();
//        list.head = new Source().deleteAtHead4(list.head);
//        list.print();
    }
}
