package source.lvl4.p29;
import source.support.datastructure.list.SinglyLinkedList;
import source.support.datastructure.node.ListNode;

class Source {
    /* ********************************************************************* */
    private static ListNode sumTwoLinkedLists(ListNode input1, ListNode input2) {
        ListNode res = null;
        ListNode prev = null;
        ListNode temp = null;
        int carry = 0, sum;
        while (input1 != null || input2 != null)
        {
            sum = carry + (input1 != null ? input1.data : 0) + (input2 != null ? input2.data : 0);
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            temp = new ListNode(sum);
            if (res == null) res = temp;
            else prev.next = temp;
            prev = temp;
            if (input1 != null) input1 = input1.next;
            if (input2 != null) input2 = input2.next;
        }
        if (carry > 0) temp.next = new ListNode(carry);
        return res;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        for(int i = 1; i < args.length; i++) {
            if(i < Integer.parseInt(args[0]) + 1) list1.append(Integer.parseInt(args[i]));
            else list2.append(Integer.parseInt(args[i]));
        }
        list1.print();
        list2.print();
        ListNode node = sumTwoLinkedLists(list1.head, list2.head);
        while(node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("[X]");
    }
}
