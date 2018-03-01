package source.lvl4.p09;
import java.util.*;
class Source {
    /* ********************************************************************* */
    /*
     * Note that if the digits in the string are unique, you should have a 
     * returned array of 3^N, where N is the number of digits; however, 
     * if the string contains same numbers, you may want to watch out 
     * and use a Set<> approach.
     */
    private static ArrayList<String> getStringsFromNums(String digits) {
        Map<Character, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        try {
            String s = "";
            for(int i = 0; i < digits.length(); i++) 
                s += map.get(digits.charAt(i));
            for(int i = 0; i < s.length(); i++)
                for(int j = 0; j < s.length(); j++) {
                    if(s.charAt(i) == s.charAt(j)) continue;
                    // add check for same string, reversed chars
                    String a = s.charAt(i) + "" + s.charAt(j);
                    list.add(a);
                }
        } catch(Exception e) {}
        return list;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(Source.getStringsFromNums(args[0]));

    }
}
