package source.lvl3.p08;
import source.temp.list.DoublyLinkedList;
import source.temp.node.DoublyListNode;
class Source {
    /* ********************************************************************* */
    private DoublyListNode insertAtHead(DoublyListNode head, int data) {
        DoublyListNode node = new DoublyListNode(data);
        if(head == null) return node;
        head.prev = node;
        node.next = head;
        return node;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().insertAtHead(list.head, Integer.parseInt(args[0]));
        list.print();
    }
}
