package source.lvl2.p27;
import source.support.datastructure.list.SinglyLinkedList;
import source.support.datastructure.node.ListNode;
class Source {
    /* ********************************************************************* */
    private boolean isListEven(ListNode head) {
        if(head == null) return true;
        ListNode node = head;
        int counter = 0;
        while(node != null) {
            counter++;
            node = node.next;
        }
        return counter % 2 == 0;
    }
    /* ********************************************************************* */
    private boolean isListEven2(ListNode head) {
        boolean even = true;
        while(head != null) {
            even = !even;
            head = head.next;
        } 
        return even;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 0; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        System.out.println(new Source().isListEven(list.head));
        System.out.println(new Source().isListEven2(list.head));
    }
}
