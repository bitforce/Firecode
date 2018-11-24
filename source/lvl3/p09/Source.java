package source.lvl3.p09;
import source.support.datastructure.list.SinglyLinkedList;
import source.support.datastructure.node.ListNode;

class Source {
    /* ********************************************************************* */
    private ListNode findNthNodeFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return null;
        ListNode node = head;
        int len = 1;
        while(node.next != null) {
            node = node.next;
            len++;
        }
        if(n > len) return null;
        node = head;
        for(int  i = 0; node != null && i < len-n; i++)
            node = node.next;
        return node;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        final int N = Integer.parseInt(args[0]);
        list.print();
        System.out.println(new Source().findNthNodeFromEnd(list.head, N).data);
    }
}
