package source.lvl3.p27;
import source.support.datastructure.list.DoublyLinkedList;
import source.support.datastructure.node.DoublyListNode;

class Source {
    /* ********************************************************************* */
    private DoublyListNode deleteAtPos(DoublyListNode head, int pos) {
        if(head == null || pos < 1) return head;
        if(pos == 1) return head.next;
        DoublyListNode curr = head;
        DoublyListNode prev = null;
        for(int i = 0; curr != null && i < pos-1; i++) {
            prev = curr;
            curr = curr.next;
        }
        if(curr == null) return head;
        if(curr.next != null) {
            prev.next = curr.next;
            curr.next.prev = prev;
        } else {
            prev.next = null;
            curr = null;
        }
        return head;
    }
    private DoublyListNode deleteAtPos2(DoublyListNode head, int pos) {
        if(head == null) return null;
        if(head.next == null) return pos == 1 ? null : head;
        DoublyListNode curr = head;
        DoublyListNode prev = null;
        int count = 1;
        while(curr != null) {
            if(count == pos) break;
            count++;
            prev = curr;
            curr = curr.next;
        }
        if(count < pos) return head;
        if(curr.next == null) {
            prev.next = null;
            curr.prev = null;
            return head;
        }
        if(count == 1) {
            DoublyListNode temp = curr;
            curr.next.prev = null;
            curr = curr.next;
            temp.next = null;
            return curr;
        }
        prev.next = curr.next;
        curr.prev = null;
        curr.next.prev = prev;
        curr.next = null;
        return head;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        for(int i = 1; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.head = new Source().deleteAtPos(list.head, Integer.parseInt(args[0]));
        list.print();
        list.head = new Source().deleteAtPos2(list.head, Integer.parseInt(args[0]));
        list.print();
    }
}
