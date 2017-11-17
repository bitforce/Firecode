package source.lvl1.p13;
class Source {
    /* ********************************************************************* */
    public static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }
    /* ********************************************************************* */
    public static int fib2(int n) {
        return (n<2) ? n : fib(n-1)+fib(n-2);
    }
    /* ********************************************************************* */
    public static int fib3(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        System.out.println(fib(N));
        System.out.println(fib2(N));
        System.out.println(fib3(N));
    }
}
