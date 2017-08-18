class DeleteNodeTail {
    private static Node head;
    private static DeleteNodeTail linkedlist;

    DeleteNodeTail(int data) {
        head = new Node(data);
    }

    DeleteNodeTail() {}

    public static void main (String[] args) {
        if (args.length == 0) {
            linkedlist = new DeleteNodeTail();
            linkedlist.deleteAtTail(head);
            System.out.println("NULL");
            return;
        }
        linkedlist = new DeleteNodeTail(Integer.parseInt(args[0])); 
        for (int i = 1; i < args.length; i++) 
            linkedlist.append(Integer.parseInt(args[i]), head);
        printList();
        head = linkedlist.deleteAtTail(head);
        printList();
    }

    // ========================================
    // TARGET METHOD
    // ========================================
    private Node deleteAtTail (Node head) {
        if (head == null || head.next == null)
            return null;
        Node temp = head;
        while(temp.next.next != null)
            temp = temp.next;
        temp.next = null;
        return head;
    }
    // ========================================
    
    private static void printList () {
        if (head == null) {
            System.out.println("NULL");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print("[" + temp.data + "] --> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }

    private Node append (int data, Node head) {
        if (head == null)
            return head = new Node(data);
        Node node = new Node(data);
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
        head = temp;
        return head;
    }

    private class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

}
