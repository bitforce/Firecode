import java.util.HashMap;
class FindFirstNonRepeatedCharacter {
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

    /* CLEANEST SOLUTION */
    // How it works:
    /*
     * If char c is located again in a different part of the string, 
     * String.lastIndexOf() will go to that part instead of staying 
     * at where it's first located in the beginning of the string.
     * So the conditional states that if both the current index 
     * and the last index are the same, it's because there only 
     * exists one of that character--making it unique--and it's
     * the first unique character to be found since indexOf() 
     * method is traversing from the beginning.
     */
    private static Character findFirstNonRepeatedCharacter2(String str) {
        for(char c : str.toCharArray())
            if(str.indexOf(c) == str.lastIndexOf(c)) return c;
        return null;
    }

    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatedCharacter(args[0])+"\n--");
        System.out.println(findFirstNonRepeatedCharacter2(args[1]));
        for(char c : args[2].toCharArray())
            System.out.print(args[2].lastIndexOf(c) + " ");
        System.out.println();
    }
}
