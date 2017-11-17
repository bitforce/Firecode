package source.lvl1.p05;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
class Source {
    /* ********************************************************************* */
    private ListNode findMiddleNode(ListNode head) {
        if(head == null) return null;
        int count = 1;
        ListNode temp = head.next;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        temp = head;
        if(count % 2 == 0) {
            int x = 1;
            while(x < count/2) {
                temp = temp.next;
                x++;
            }
        } else {
            int x = 0;
            while(x < count/2) {
                temp = temp.next;
                x++;
            }
        } 
        return temp;
    }
    /* ********************************************************************* */
    private ListNode findMiddleNode2(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    /* ********************************************************************* */
    public static void main (String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < args.length; i++) 
            list.append(Integer.parseInt(args[i]));
        list.print();
        System.out.println(new Source().findMiddleNode(list.head).data);
        System.out.println(new Source().findMiddleNode2(list.head).data);
    }
}
