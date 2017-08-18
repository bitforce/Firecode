/**
 * Anagrams.
 * Write a method isAnagram that checks if two lowercase input Strings are 
 * anagrams of each other. An anagram of a String is a String that is 
 * formed by simply re-arranging its letters, using each letter 
 * exactly once. Your algorithm should run in linear O(n) time 
 * and use constant O(1) space. 
 */
class Anagrams {
    private static boolean isAnagram(String a, String b) {
        if((a == null || b == null) || (a.length() != b.length())) 
            return false;
        int asum = 0;
        int bsum = 0;
        for(int i = 0 ; i < a.length(); i++) {
            asum += (int) a.charAt(i);
            bsum += (int) b.charAt(i);
        }
        return asum == bsum;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram(args[0], args[1]));
    }
}
