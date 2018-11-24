package source.lvl2.p20;

class Source {
    static boolean isPowerOfTwo(int num) {
        if(num < 1) return false;
        while(num >= 2) {
            if(num % 2 == 0)
                num /= 2;
            else return false;
        }
        return true;
    }
   /* ********************************************************************** */ 
    static boolean isPowerOfTwo2(int num) {
        if(num < 1) return false;
        return (num & (num - 1)) == 0;
    }
}
