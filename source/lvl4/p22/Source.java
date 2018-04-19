package source.lvl4.p22;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static ArrayList<String> getCombPerms(String s) {
        return s != null ? getCombPerms(s, new ArrayList<>()) : null;
    }
    private static ArrayList<String> getCombPerms(String s, ArrayList<String> a) {
        if(a.contains(s)) return a;
        a.add(s);
        return getCombPerms(s, a);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        for(String s : getCombPerms(args[0]))
            System.out.print(s + " ");
    }
}
