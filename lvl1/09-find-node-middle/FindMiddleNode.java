class FindMiddleNode {
    private static Node head;
    private static FindMiddleNode linkedlist;

    FindMiddleNode() {}
    FindMiddleNode(int data) {head = new Node(data);}

    public static void main (String[] args) {
        if (args.length == 0) {
            linkedlist = new FindMiddleNode();
            linkedlist.findMiddleNode(head);
            printList();
            return;
        }
        linkedlist = new FindMiddleNode(Integer.parseInt(args[0])); 
        for (int i = 1; i < args.length; i++) 
            linkedlist.append(Integer.parseInt(args[i]), head);
        printList();
        head = linkedlist.findMiddleNode2(head);
        System.out.println("[" + head.data + "]");
    }

    // ========================================
    // TARGET METHOD
    // ========================================
    private Node findMiddleNode(Node head) {
        if(head == null) return null;
        int count = 1;
        Node temp = head.next;
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
    // ========================================

    /* BETTER */
    private Node findMiddleNode2(Node head) {
        if(head == null) return null;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
