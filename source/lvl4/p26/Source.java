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
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),
            new Comparator<ListNode>() {
                public int compare(ListNode a, ListNode b) {
                    if (a.data > b.data) return 1;
                    else if(a.data == b.data) return 0;
                    else return -1;}});
        for (ListNode list : lists) if (list != null) queue.add(list);
        ListNode head = new ListNode(0), curr = head; 
        while (queue.size() > 0) {
            ListNode temp = queue.poll();
            curr.next = temp;
            if (temp.next != null) queue.add(temp.next); 
            curr = curr.next;
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
        ListNode head = new Source().mergeKLists(lists);
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println();
        head = new Source().mergeKLists(lists);
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println();

    }
}
