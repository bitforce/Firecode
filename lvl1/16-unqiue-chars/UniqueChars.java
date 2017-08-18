import java.util.*;

class UniqueChars {
    private static boolean areAllCharactersUnique(String str) {
        if(str == null || str.length() <= 1) return true;
        Set<Character> set = new HashSet<>();
        for(char c : str.toCharArray()) set.add(c);
        if(set.size() == str.length()) return true;
        return false;
    }
    private static boolean areAllCharactersUnique2(String str) {
        if(str == null || str.length() <= 1) return true;
        boolean[] checker_array = new boolean[256];
        for(int i = 0; i < str.length(); i++){
            int position = str.charAt(i);
            if(checker_array[position]) return false;
            checker_array[position] = true;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(areAllCharactersUnique(args[0]));
        System.out.println(areAllCharactersUnique2(args[1]));
    }
}
