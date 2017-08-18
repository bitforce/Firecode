import java.util.*;

/**
 * Isomorphic Strings.
 * Given two strings - input1 and input2, determine if they are isomorphic. 
 * Two strings are isomorphic if the letters in one string can be remapped 
 * to get the second string. Remapping a letter means replacing all 
 * occurrences of it with another letter. The ordering of the 
 * letters remains unchanged. You can also think of 
 * isomorphism as it is used in chemistry - i.e. 
 * having the same form or overall shape. Target 
 * linear time and space complexity with your
 * solution.
 */
class IsomorphicStrings {
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

    public static void main(String[] args) {
        System.out.println(isIsomorphic(args[0], args[1]));
        System.out.println(isIsomorphic2(args[0], args[1]));
    }
}
