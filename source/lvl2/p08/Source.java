package source.lvl2.p08;

class Source {
    static int reverseInt(int x) {
        if (x > -10 && x < 10) return x;
        final StringBuilder s = new StringBuilder();
        while(x != 0) {
            s.append(x % 10);
            x = Math.abs(x);
            x /= 10;
        }
        return Integer.parseInt(s.toString());
    }
    /* ********************************************************************* */
    static int reverseInt2(int x) {
        int rev = 0;
        while(x != 0) {
            rev = rev*10 + x%10;
            x /= 10;
        }
        return rev;
    }
}
