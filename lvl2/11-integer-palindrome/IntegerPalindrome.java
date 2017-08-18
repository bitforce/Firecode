class IntegerPalindrome {
    private static boolean isIntPalindrome(int x) {
        if(new StringBuilder(x+"").reverse().toString().equals(x+""))
            return true;
        return false;
    }
    
    private static boolean isIntPalindrome2(int x) {
        int num = x, reverse=0, remainder; 
        while(num > 0) { 
            remainder = num % 10; 
            reverse = reverse * 10 + remainder; 
            num = num / 10; 
        } 
        return reverse == x;
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println(isIntPalindrome(x));
        System.out.println(isIntPalindrome2(x));
    }
}
