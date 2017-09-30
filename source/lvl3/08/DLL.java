class DLL {
    private DoublyListNode head;
    /* ********************************************************************* */
    private DoublyListNode insertAtHead(DoublyListNode head, int data) {
        DoublyListNode node = new DoublyListNode(data);
        if(head == null) return node;
        head.prev = node;
        node.next = head;
        return node;
    }
    /* ********************************************************************* */
    private void append(int data) {
        if(head != null) {
            DoublyListNode node = new DoublyListNode(data);
            head.next = node;
            node.prev = head;
        } else head = new DoublyListNode(data);
    }
    private void print() {
        if (head == null) return;
        DoublyListNode temp = head;
        while (temp != null) {
            System.out.print("[" + temp.data + "] <--> ");
            temp = temp.next;
        }
        System.out.print("[X]\n");
    }
    public static void main(String[] args) {
        DLL list = new DLL();
        for(int i = 0; i < args.length-1; i++)
            list.append(Integer.parseInt(args[i+1]));
        list.print();
        list.head = list.insertAtHead(list.head, Integer.parseInt(args[0]));
        list.print();
    }
    private class DoublyListNode {
        int data;
        DoublyListNode next;  
        DoublyListNode prev;
        public DoublyListNode(int data) {this.data = data;}
    } 
}
