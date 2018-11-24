package source.lvl1.p13;

import static source.lvl1.p13.Source.fib;
import static source.lvl1.p13.Source.fib2;
import static source.lvl1.p13.Source.fib3;

public class SourceMain {
     public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        System.out.println(fib(N));
        System.out.println(fib2(N));
        System.out.println(fib3(N));
    }
}
