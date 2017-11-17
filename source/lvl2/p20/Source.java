package source.lvl2.p20;
class Source {
   /* ********************************************************************** */ 
    private static boolean isPowerOfTwo(int num) {
        if(num < 1) return false;
        while(num >= 2) {
            if(num % 2 == 0)
                num /= 2;
            else return false;
        }
        return true;
    }
   /* ********************************************************************** */ 
    private static boolean isPowerOfTwo2(int num) {
        if(num < 1) return false;
        return (num & (num - 1)) == 0;
    }
   /* ********************************************************************** */ 
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(Integer.parseInt(args[0])));
        System.out.println(isPowerOfTwo2(Integer.parseInt(args[0])));
    }
}
