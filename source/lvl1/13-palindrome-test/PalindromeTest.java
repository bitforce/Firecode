/**
 * ABSTRACT
 * ........
 * Palindrome is a string or sequence of characters that reads the same
 * backward as forward. For example, "madam" is a palindrome. Write a 
 * method that takes in a String and returns a boolean -> true if the 
 * input String is a palindrome and false if it is not. An empty 
 * string and a null input are considered palindromes. You also 
 * need to account for the space character.
 *  
 * For example, "race car" should return false
 * ---------------------------------------------------------------------------- 
 * conditions
 * ----------
 * string may be null, empty, or a string.
 */
class PalindromeTest {
    private static boolean isStringPalindrome(String str) {
        if(str == null || str.equals("") || str.length() < 2) return true;
        if(str.charAt(0) == str.charAt(str.length()-1))
            return isStringPalindrome(str.substring(1, str.length()-1));
        return false;
    }
    private static boolean isStringPalindrome2(String str) {
        if(str == null || str.equals("") || str.length() < 2) return true;
        return str.charAt(0) == str.charAt(str.length()-1) && 
               isStringPalindrome2(str.substring(1, str.length()-1));
    }
    public static void main(String[] args) {
        System.out.println(isStringPalindrome(null));
        System.out.println(isStringPalindrome(args[0]));
        System.out.println(isStringPalindrome2(null));
        System.out.println(isStringPalindrome2(args[0]));
    }
}
