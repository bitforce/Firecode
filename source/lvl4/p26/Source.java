package source.lvl4.p26;

import source.support.datastructure.node.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Source {
    /* ********************************************************************* */
    ListNode mergeKLists(final ArrayList<ListNode> lists) {
        return !lists.isEmpty() ? mergeKLists(lists, 0, lists.size()-1) : null;
    }
    private ListNode mergeKLists(final ArrayList<ListNode> lists, final int LEFT, final int RIGHT) {
        if(LEFT < RIGHT) {
            final int mid = (LEFT + RIGHT) / 2;
            return merge(mergeKLists(lists, LEFT, mid), mergeKLists(lists, mid+1, RIGHT));
        }
        return lists.get(LEFT);
    }
    private ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while(a != null && b != null) {
            if(a.data < b.data) {
                prev.next = a;
                prev = prev.next;
                a = a.next;
            } else {
                prev.next = b;
                prev = prev.next;
                b = b.next;
            }
        }
        if(a != null) prev.next = a;
        else prev.next = b;
        return head.next;
    }
    /* ********************************************************************* */
    ListNode mergeKLists2(final ArrayList<ListNode> lists) {
        if (lists.size() == 0)  return null;
        final PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));
        for (ListNode list : lists) if(list != null) queue.offer(list);
        final ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode prev = head;
        while(!queue.isEmpty()) {
            ListNode temp = queue.poll();
            prev.next = temp;
            prev = prev.next;
            if(temp.next != null) queue.offer(temp.next);
        }
        return head.next;
    }
    /* ********************************************************************* */
    ListNode mergeKLists3(final ArrayList<ListNode> lists) {
        if (lists.size() == 0)  return null;
        final PriorityQueue<ListNode> queue =
                new PriorityQueue<>(lists.size(), Comparator.comparingInt(node -> node.data));
        for (ListNode list : lists) if (list != null) queue.add(list);
        final ListNode head = new ListNode(0);
        ListNode curr = head;
        while (queue.size() > 0) {
            ListNode temp = queue.poll();
            curr.next = temp;
            if (temp.next != null)
                queue.add(temp.next); 
            curr = curr.next;
        }
        return head.next;
    }
}
