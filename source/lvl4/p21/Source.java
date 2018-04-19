package source.lvl4.p21;
import source.temp.list.CircularlyLinkedList;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private boolean isCyclic(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;
        }
        return false;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        CircularlyLinkedList clist = new CircularlyLinkedList();
        SinglyLinkedList slist = new SinglyLinkedList();
        for(int i = 0; i < args.length; i++) {
            clist.append(Integer.parseInt(args[i]));
            slist.append(Integer.parseInt(args[i]));
        }
        clist.print();
        slist.print();
        System.out.println(new Source().isCyclic(clist.head));
        System.out.println(new Source().isCyclic(slist.head));
    }
}
