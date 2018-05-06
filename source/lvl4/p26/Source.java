package source.lvl4.p26;
import source.temp.list.SinglyLinkedList;
import source.temp.node.ListNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private ListNode mergeKLists(ArrayList<ListNode> lists) {
        return null;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        // until your stupid fucking midn can figure out how to appropriately grab these values, 
        // just hardecode this shit like the idiot fucking retard you are
        ArrayList<ListNode> lists = new ArrayList<>();
        int numberOfLists = Integer.parseInt(args[0]); 
        int k = 1; // shifts to appropriate parsing placeholder
        for(int i = 0; i < numberOfLists; i++) {
            int numberOfElements = Integer.parseInt(args[i+1]);
            for(int j = 0; j < Integer.parseInt(args[numberOfElements]); j++) {
                System.out.println(Integer.parseInt(args[k + numberOfElements + j]));
                k++;
            }
        }
        System.out.println(new Source().mergeKLists(lists));
    }
}
