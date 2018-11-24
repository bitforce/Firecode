package source.lvl1.p13;

class Source {
    static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }
    /* ********************************************************************* */
    static int fib2(int n) {
        return (n<2) ? n : fib(n-1)+fib(n-2);
    }
    /* ********************************************************************* */
    static int fib3(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }
}
