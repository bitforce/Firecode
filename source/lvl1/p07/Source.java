package source.lvl1.p07;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static Character findFirstNonRepeatedCharacter(String str) {
        Character c;
        int i = 0, length = str.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(; i < length; i++) {
            c = str.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c,1);
        }
        i = 0;
        for(; i < length; i++) {
            c = str.charAt(i);
            if(map.get(c) == 1) return c;
        }
        return null;
    }
    /* ********************************************************************* */
    private static Character findFirstNonRepeatedCharacter2(String str) {
        for(char c : str.toCharArray())
            if(str.indexOf(c) == str.lastIndexOf(c)) return c;
        return null;
    }

    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatedCharacter(args[0]));
        System.out.println(findFirstNonRepeatedCharacter2(args[0]));
    }
}
