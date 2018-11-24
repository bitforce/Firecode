package source.lvl2.p11;

class Source {
    static boolean isIntPalindrome(int x) {
        return new StringBuilder(x + "").reverse().toString().equals(x + "");
    }
    /* ********************************************************************** */
    static boolean isIntPalindrome2(int x) {
        int num = x, reverse=0, remainder; 
        while(num > 0) { 
            remainder = num % 10; 
            reverse = reverse * 10 + remainder; 
            num = num / 10; 
        } 
        return reverse == x;
    }
}
