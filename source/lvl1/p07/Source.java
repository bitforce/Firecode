package source.lvl1.p07;

import java.util.*;

class Source {
    static Character findFirstNonRepeatedCharacter(String str) {
        Character c;
        final int length = str.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < length; i++) {
            c = str.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c,1);
        }
        for(int i = 0; i < length; i++) {
            c = str.charAt(i);
            if(map.get(c) == 1) return c;
        }
        return null;
    }
    /* ********************************************************************* */
    static Character findFirstNonRepeatedCharacter2(String str) {
        for(char c : str.toCharArray())
            if(str.indexOf(c) == str.lastIndexOf(c)) return c;
        return null;
    }
}
