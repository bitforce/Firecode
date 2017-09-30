class Reverse {
    private static int reverseInt(int x) {
        if (x > -10 && x < 10) return x;
        String s = "";
        while(x != 0) {
            s += (x % 10);
            x = Math.abs(x);
            x /= 10;
        }
        return Integer.parseInt(s);
    }
    private static int reverseInt2(int x) {
        int rev = 0;
        while(x != 0) {
            rev = rev*10 + x%10;
            x /= 10;
        }
        return rev;
    }
    public static void main(String[] args) {
        System.out.println(reverseInt(Integer.parseInt(args[0])));
        System.out.println(reverseInt2(Integer.parseInt(args[0])));
    }
}
