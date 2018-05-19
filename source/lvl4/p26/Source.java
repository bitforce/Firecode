package source.lvl4.p26;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private ListNode mergeKLists(ArrayList<ListNode> lists) {
        return lists.size() > 0 ? mergeKLists(lists, 0, lists.size()-1) : null;
    }
    private ListNode mergeKLists(ArrayList<ListNode> lists, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            return merge(mergeKLists(lists, left, mid), mergeKLists(lists, mid+1, right));
        }
        return lists.get(left);
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
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        if (lists.size() == 0)  return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new
                Comparator<ListNode>(){public int compare(ListNode a, ListNode b){
                    return a.data - b.data;
                }});
        for (ListNode list : lists) queue.offer(list);
        ListNode head = new ListNode(Integer.MIN_VALUE);
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
    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<>();
        int numberOfLists = Integer.parseInt(args[0]);
		int k = 0;
        for(int i = 0; i < numberOfLists; i++) {
            SinglyLinkedList list = new SinglyLinkedList();
            for(int j = 0; j < Integer.parseInt(args[i+1]); j++) {
                list.append(Integer.parseInt(args[numberOfLists+i+k+1]));
                k++;
            }
            k--;
            lists.add(list.head);
            list.print();
        }
        // NOTE - both methods do give the correct answer, but running them
        // sequentially forces a infinite recursive call
        print(new Source().mergeKLists(lists));
        print(new Source().mergeKLists2(lists));
    }
    private static void print(ListNode head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println();
    }
}
