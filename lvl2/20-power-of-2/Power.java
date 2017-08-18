/**
 * Power of 2.
 * Write a method - isPowOfTwo() to test whether or not a given positive integer 
 * is a power of 2. Your method should run in constant O(1) time and use 
 * O(1) space.
 */
class Power {
    private static boolean isPowerOfTwo(int num) {
        if(num < 1) return false;
        while(num >= 2) {
            if(num % 2 == 0)
                num /= 2;
            else return false;
        }
        return true;
    }

    private static boolean isPowerOfTwo2(int num) {
        if(num < 1) return false;
        return (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(Integer.parseInt(args[0])));
        System.out.println(isPowerOfTwo2(Integer.parseInt(args[0])));
    }
}
