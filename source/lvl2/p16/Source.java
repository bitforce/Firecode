package source.lvl2.p16;
import java.util.*;
class Source {
   /* ********************************************************************** */
    private static boolean isIsomorphic(String input1, String input2) {
        if(input1 == null || input2 == null || input1.length() != input2.length())
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < input1.length(); i++) {
            if(!map.containsKey(input1.charAt(i)) && !map.containsValue(input2.charAt(i)))
                map.put(input1.charAt(i), input2.charAt(i));
            if(map.get(input1.charAt(i)) == null)
                return false;
            if(!map.get(input1.charAt(i)).equals(input2.charAt(i)))
                return false;
        }
        return true;
    }
   /* ********************************************************************** */
    private static boolean isIsomorphic2(String input1, String input2) {
        if (input1 == null || input2 == null || input1.length() != input2.length())
            return false; 
        int charcount = 0;
        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();
        for (int i = 0; i < input1.length(); i++) {
            char c1 = input1.charAt(i);
            char c2 = input2.charAt(i);            
            if (h1.get(c1) != h2.get(c2)) return false;
            if (h1.get(c1) == null) {
                h1.put(c1, charcount);
                h2.put(c2, charcount);
                charcount++;
            }
        }
        return true;
    }
   /* ********************************************************************** */
    public static void main(String[] args) {
        System.out.println(isIsomorphic(args[0], args[1]));
        System.out.println(isIsomorphic2(args[0], args[1]));
    }
}
