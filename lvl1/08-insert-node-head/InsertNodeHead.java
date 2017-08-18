class InsertNodeHead {
    private static Node head;
    private static InsertNodeHead linkedlist;

    InsertNodeHead() {}
    InsertNodeHead(int data) {head = new Node(data);}

    public static void main (String[] args) {
        if (args.length == 0) {
            linkedlist = new InsertNodeHead();
            linkedlist.insertAtHead(head, Integer.MAX_VALUE);
            printList();
            return;
        }
        linkedlist = new InsertNodeHead(Integer.parseInt(args[0])); 
        for (int i = 1; i < args.length-1; i++) 
            linkedlist.append(Integer.parseInt(args[i]), head);
        printList();
        head = linkedlist.insertAtHead(head, 
                Integer.parseInt(args[args.length-1]));
        printList();
    }

    // ========================================
    // TARGET METHOD
    // ========================================
    private Node insertAtHead(Node head, int data) {
        if(head == null) return new Node(data);
        Node temp = new Node(data);
        temp.next = head;
        return head = temp;
    }
    // ========================================
    
    private Node insertAtHead2(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;
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
