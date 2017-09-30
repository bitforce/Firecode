class DeleteNodeHead {
    private static Node head;
    private static DeleteNodeHead linkedlist;

    DeleteNodeHead(int data) {
        head = new Node(data);
    }

    DeleteNodeHead() {}

    public static void main (String[] args) {
        if (args.length == 0) {
            linkedlist = new DeleteNodeHead();
            linkedlist.deleteAtHead(head);
            System.out.println("NULL");
            return;
        }
        linkedlist = new DeleteNodeHead(Integer.parseInt(args[0])); 
        for (int i = 1; i < args.length; i++) 
            linkedlist.append(Integer.parseInt(args[i]), head);
        printList();
        head = linkedlist.deleteAtHead(head);
        printList();
    }

    // ========================================
    // TARGET METHOD
    // ========================================
    private Node deleteAtHead (Node head) {
        if (head == null)
            return null;
        return head = head.next;
    }
    // ========================================

    private Node deleteAtHead2 (Node head) {
        return (head != null) ? head.next : null;
    }
    
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
