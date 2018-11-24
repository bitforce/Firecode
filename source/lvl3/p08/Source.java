package source.lvl3.p08;

import source.support.datastructure.node.DoublyListNode;

class Source {
    DoublyListNode insertAtHead(DoublyListNode head, int data) {
        final DoublyListNode node = new DoublyListNode(data);
        if(head == null) return node;
        head.prev = node;
        node.next = head;
        return node;
    }
}
