package source.lvl2.p20;

import static source.lvl2.p20.Source.isPowerOfTwo;
import static source.lvl2.p20.Source.isPowerOfTwo2;

public class SourceMain {
     public static void main(String[] args) {
        System.out.println(isPowerOfTwo(Integer.parseInt(args[0])));
        System.out.println(isPowerOfTwo2(Integer.parseInt(args[0])));
    }
}
