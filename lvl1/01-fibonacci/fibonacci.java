class Fibonacci {
    /**
     * Write a recursive method fib(n) that returns the nth Fibonacci number. n
     * is 0 indexed, which means that in the sequence 0, 1, 1, 2, 3, 5, 8, 13,
     * 21, 34, ..., n == 0 should return 0 and n == 3 should return 2. Assume n
     * is less than 15.
     *
     * Even though this problem asks you to use recursion, more efficient ways
     * to solve it include using an Array, or better still using 3 volatile
     * variables to keep a track of all required values. Check out this blog
     * post to examine better solutions for this problem.
     */
    public static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fib(Integer.parseInt(args[0])));
    }

    // ----------------------------------------
    // ALTERNATE SOLUTIONS
    // ----------------------------------------
    public static int fib2(int n) {
        return (n<2) ? n : fib(n-1)+fib(n-2);
    }

    public static int fib3(int n) {
        // Add your code below this line. Do not modify any other code.
        if (n == 0) return 0;
        if (n <= 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }
}
