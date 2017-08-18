import java.util.*;

/**
 * Insert Stars.
 * Given a string, recursively compute a new string where the identical 
 * adjacent characters in the original string are separated by a "*".
 * Since the problem doesn't define how to treat already found stars, 
 * we are not obliged to sue the conditional found in the original 
 * insertPairStars solution and thus either solution works.
 */
class InsertStars {
    private static String insertPairStar(String s) {
        if(s == null || s.length() < 2) return s;
        String temp = "";
        int i = 0;
        if(s.charAt(i) != '*' && s.charAt(i) == s.charAt(i+1))
            return s.substring(0,1) + "*" + insertPairStar(s.substring(1, s.length()));
        return s.substring(0,1) + insertPairStar(s.substring(1, s.length()));
    }

    private static String insertPairStar2(String s) {
        if(s==null || s.length()<=1) return s;
        return s.charAt(0) + (s.charAt(0) == s.charAt(1) ? "*" : "") 
                           + insertPairStar2(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(insertPairStar(args[0]));
        System.out.println(insertPairStar2(args[0]));
    }
}
