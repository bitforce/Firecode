class CircularLinkedList {
    private static ListNode head;
    
    private void append(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
            head.next = node;
            node = head;
            return;
        }
        /* ********************* */
        ListNode tail = head;
        while(tail.next != head)
           tail = tail.next; 
        /* ********************* */   
        tail.next = node;
        tail = node;
        tail.next = head;
    }

    private void print() {
        if(head == null)
            System.out.println("[X]");
        else {
            ListNode temp = head;
            while(temp.next != head) {
                System.out.print("[" + temp.data + "] --> ");
                temp = temp.next;
            }
            System.out.print("[" + temp.data + "] --> *\n");
        }
    }

   /* ********************************************************************** */ 
    private ListNode deleteAtHead(ListNode head) {
        if(head == null || head.next == head) return null;
        /* ********************* */
        ListNode tail = head;
        while(tail.next != head)
            tail = tail.next;
        /* ********************* */
        head = head.next;
        tail.next = head;
        return head;
    }

    private ListNode deleteAtHead2(ListNode head) {
        if (head == null)
            return null;
        ListNode tail = head;
        while(tail.next != head)
            tail = tail.next;
        tail.next = head.next;        
        head.next = null;
        head = tail.next;
        return head;
    }

    // BEST SOLUTION AWARD
    private ListNode deleteAtHead3(ListNode head) {
        if (head == null || head.next == head)
            return null;
        head.data = head.next.data;
        return head.next = head.next.next;
    }

    private ListNode deleteAtHead4(ListNode head) {
        if (head == null || head.next == head) return null; 
        ListNode tail = head;
        while (tail.next != head)
            tail = tail.next;
        return tail.next = head.next;
    }
   /* ********************************************************************** */ 

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        for(int i = 0; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        list.deleteAtHead3(head);
        list.print();
//        list.deleteAtHead(head);
//        list.print();
//        list.deleteAtHead2(head);
//        list.print();
//        list.deleteAtHead3(head); // the only one that works
//        list.print();
//        list.deleteAtHead4(head);
//        list.print();
    }
    
    private class ListNode {
        int data;
        ListNode next;        
        ListNode(int data) { this.data = data; }
     }
}
