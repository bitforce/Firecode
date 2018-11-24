package source.lvl3.p38;
import source.support.datastructure.list.SinglyLinkedList;
import source.support.datastructure.node.ListNode;

class Source {
    /* ********************************************************************* */
    private ListNode findNthNodeFromEnd(ListNode head, int n) {
        if(head == null || n < 1) return null;
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        if(n > len) return null;
        final int LEN = len - n;
        temp = head;
        for(int i = 0; i < LEN; i++)
            temp = temp.next;
        return temp;
    }
    /* ********************************************************************* */
    private ListNode findNthNodeFromEnd2(ListNode head, int n) {
        ListNode node = head;
        int len = 0;
        while(node != null) {
            node = node.next;
            len++;
        }
        final int POS = len - n + 1;
        int count = 0;
        node = head;
        while(node != null) {
            count++;
            if(count == POS)
                break;
            node = node.next;
        }
        return node;
    }
    /* ********************************************************************* */
    private ListNode findNthNodeFromEnd3(ListNode head, int n) {
        if(head == null || n <= 0) return null;
        ListNode fast = head;
        ListNode slow = null;
        while(fast != null) {
            fast = fast.next;
            if(n > 1) {
                n -= 1;
            } else if(n == 1) {
                slow = head;
                n -= 1;
            } else slow = slow.next;
        }
        return slow;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[0]);
        System.out.println(new Source().findNthNodeFromEnd(list.head, N).data);
        System.out.println(new Source().findNthNodeFromEnd2(list.head, N).data);
        System.out.println(new Source().findNthNodeFromEnd3(list.head, N).data);
    }
}
