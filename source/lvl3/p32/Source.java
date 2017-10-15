package source.lvl3.p32;
import source.temp.list.CircularlyLinkedList;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private boolean isCyclic(ListNode head) {
        if(head == null) return false;
        Map<Integer, Boolean> map = new HashMap<>();
        while(head != null) {
            if(map.containsKey(head.data)) return map.get(head.data);
            map.put(head.data, true);
            head = head.next;
        }
        return false;
    }
    /* ********************************************************************* */
    private boolean isCyclic2(ListNode head) {
        boolean cyclic = false;
        Hashtable<ListNode, Integer> table = new Hashtable<>();
        while(head != null) {
            if(table.containsKey(head)) {
                cyclic = true;
                break;
            } else {
                table.put(head, head.data);
                head = head.next;
            }
        }
        return cyclic;
    }
    /* ********************************************************************* */
    private boolean isCyclic3(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            if(slow == fast) return true;
            slow = slow.next;
        }
        return false;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        CircularlyLinkedList cll = new CircularlyLinkedList();
        SinglyLinkedList sll = new SinglyLinkedList();
        for(int i = 0; i < args.length; i++) {
            sll.append(Integer.parseInt(args[i]));
            cll.append(Integer.parseInt(args[i]));
        }
        sll.print();
        System.out.println(new Source().isCyclic(sll.head));
        System.out.println(new Source().isCyclic2(sll.head));
        System.out.println(new Source().isCyclic3(sll.head));
        // CAN'T USE A CLL B/C IT WILL ALWAYS POINT BACK TO ITSELF
        cll.print();
        System.out.println(new Source().isCyclic(cll.head));
        System.out.println(new Source().isCyclic2(cll.head));
        System.out.println(new Source().isCyclic3(cll.head));
    }
}
