package source.lvl3.p29;
import source.support.datastructure.list.SinglyLinkedList;
import source.support.datastructure.node.ListNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private boolean isListPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        while(head != null) {
            if(head.data != stack.pop()) return false;
            head = head.next;
        }
        return true;
    }
    private boolean isListPalindrome2(ListNode head) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        while(head != null) {
            a.append(head.data);
            b.insert(0, head.data);
            head = head.next;
        }
        return a.toString().equals(b.toString());
    }
    private boolean isListPalindrome3(ListNode head) {
        if(head == null || head.next == null) return true;
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        int mid = len > 0 ? len/2 : 0;
        int count = 0;
        curr = head;
        while(curr != null) {
            if(count == mid) break;
            curr = curr.next;
            count++;
        }
        ListNode midl = curr;
        ListNode m = midl;
        ListNode n = m.next;
        while(m != null && n != null) {
            ListNode t = n.next;
            n.next = m;
            m = n;
            n = t;
        }
        midl.next = null;
        ListNode p = n == null ? m : n;
        ListNode q = head;
        while(p != null) {
            if(p.data != q.data) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 0; i < args.length; i++)
            list.append(Integer.parseInt(args[i]));
        list.print();
        System.out.println(new Source().isListPalindrome(list.head));
        System.out.println(new Source().isListPalindrome2(list.head));
        System.out.println(new Source().isListPalindrome3(list.head));
    }
}
