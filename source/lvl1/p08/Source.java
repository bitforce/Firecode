package source.lvl1.p08;
class Source {
    /* ********************************************************************* */
    private static boolean isStringPalindrome(String str) {
        if(str == null || str.equals("") || str.length() < 2) return true;
        if(str.charAt(0) == str.charAt(str.length()-1))
            return isStringPalindrome(str.substring(1, str.length()-1));
        return false;
    }
    /* ********************************************************************* */
    private static boolean isStringPalindrome2(String str) {
        if(str == null || str.equals("") || str.length() < 2) return true;
        return str.charAt(0) == str.charAt(str.length()-1) && 
               isStringPalindrome2(str.substring(1, str.length()-1));
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(isStringPalindrome(args[0]));
        System.out.println(isStringPalindrome2(args[0]));
    }
}
