package source.lvl4.p03;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static int longestNRSubstringLen(String input) {
        if(input == null || input.equals("")) return 0;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(longestNRSubstringLen(args[0]));
        System.out.println(longestNRSubstringLen2(args[0]));
    }
}
