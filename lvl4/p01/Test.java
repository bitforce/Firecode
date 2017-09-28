import templates.*;
class Test {
    /* ********************************************************************* */
    // TEST METHODS
    /* ********************************************************************* */
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        sll.print();

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(4);
        dll.append(5);
        dll.append(6);
        dll.print();

        CircularlyLinkedList cll = new CircularlyLinkedList();
        cll.append(7);
        cll.append(8);
        cll.append(9);
        cll.print();

        BinarySearchTree bst = new BinarySearchTree();
        bst.add(4);
        bst.add(6);
        bst.add(5);
        bst.add(2);
        bst.add(3);
        bst.add(1);
        bst.add(7);
        bst.print();

        BinaryTree bt = new BinaryTree();
        bt.add(4);
        bt.add(6);
        bt.add(5);
        bt.add(2);
        bt.add(3);
        bt.add(1);
        bt.add(7);
        bt.print();
        bt.balance();
        bt.print();
    }
}
