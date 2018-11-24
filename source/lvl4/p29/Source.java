package source.lvl4.p29;

import source.support.datastructure.node.ListNode;

class Source {
    static ListNode sumTwoLinkedLists(ListNode input1, ListNode input2) {
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
}
