package source.lvl3.p16;

import source.support.datastructure.node.ListNode;

import java.util.*;

class Source {
    /* ********************************************************************* */
    ListNode removeDuplicates(ListNode head) {
        if(head == null) return null;
        final HashMap<Integer, ListNode> map = new HashMap<>();
        final List<ListNode> list = new LinkedList<>();
        while(head != null) {
            if(!map.containsKey(head.data)) {
                map.put(head.data, head);
                list.add(new ListNode(head.data));
            }
            head = head.next;
        }
        ListNode temp = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            temp.next = list.get(i);
            temp = temp.next;
        }
        return list.get(0);
    }
    /* ********************************************************************* */
    ListNode removeDuplicates2(final ListNode head) {
        final Hashtable<Integer, ListNode> table = new Hashtable<>();
        if(head == null || head.next == null) return head;
        ListNode curr = head, prev = curr;
        while(curr != null) {
            if(table.containsKey(curr.data)) {
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
                if(curr == null) break;
                table.put(curr.data, curr);                
            } else table.put(curr.data, curr);
            prev = curr;
            curr = curr.next;                        
        }
        return head;
    }
    /* ********************************************************************* */
    ListNode removeDuplicates3(final ListNode head) {
        if(head == null || head.next == null) return head;
        final HashSet<Integer> set = new HashSet<>();
        ListNode temp = head.next;
        ListNode prev = head;
        set.add(head.data);
         while(temp != null){
             if(!set.add(temp.data)){
                 prev.next = temp.next;
             }
             prev = temp;
             temp = temp.next;
         }
        return head;
    }
}
