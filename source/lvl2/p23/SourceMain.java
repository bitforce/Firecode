package source.lvl2.p23;

import static source.lvl2.p23.Source.betterFibonacci;
import static source.lvl2.p23.Source.betterFibonacci2;

public class SourceMain {
     public static void main(String[] args) {
        System.out.println(betterFibonacci(Integer.parseInt(args[0])));
        System.out.println(betterFibonacci2(Integer.parseInt(args[0])));
    }
}
