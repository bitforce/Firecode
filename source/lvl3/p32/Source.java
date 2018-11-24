package source.lvl3.p32;

import source.support.datastructure.node.ListNode;

import java.util.HashMap;
import java.util.Hashtable;

class Source {
    boolean isCyclic(ListNode head) {
        if(head == null) return false;
        final HashMap<Integer, Boolean> map = new HashMap<>();
        while(head != null) {
            if(map.containsKey(head.data)) return map.get(head.data);
            map.put(head.data, true);
            head = head.next;
        }
        return false;
    }
    /* ********************************************************************* */
    boolean isCyclic2(ListNode head) {
        boolean cyclic = false;
        final Hashtable<ListNode, Integer> table = new Hashtable<>();
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
    boolean isCyclic3(final ListNode head) {
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
}
