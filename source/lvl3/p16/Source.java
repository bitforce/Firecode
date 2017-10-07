package source.lvl3.p16;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private ListNode removeDuplicates(ListNode head) {
        if(head == null) return null;
        Map<Integer, ListNode> map = new HashMap<>();
        List<ListNode> list = new LinkedList<>();
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
    private ListNode removeDuplicates2(ListNode head) {    
        Hashtable<Integer, ListNode> table = new Hashtable<>();
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
    private ListNode removeDuplicates3(ListNode head) {
        if(head == null || head.next == null) return head;
        HashSet<Integer> set = new HashSet<>();
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
    /* ********************************************************************* */
    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        SinglyLinkedList sll2 = new SinglyLinkedList();
        SinglyLinkedList sll3 = new SinglyLinkedList();
        for(int i = 0; i < args.length; i++) {
            sll1.append(Integer.parseInt(args[i]));
            sll2.append(Integer.parseInt(args[i]));
            sll3.append(Integer.parseInt(args[i]));
        }
        sll1.print();
        sll1.head = new Source().removeDuplicates(sll1.head);
        sll1.print();
        sll2.print();
        sll2.head = new Source().removeDuplicates2(sll2.head);
        sll2.print();
        sll3.print();
        sll3.head = new Source().removeDuplicates3(sll3.head);
        sll3.print();
    }
}
