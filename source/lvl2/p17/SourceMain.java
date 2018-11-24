package source.lvl2.p17;

import static source.lvl2.p17.Source.pow;
import static source.lvl2.p17.Source.pow2;

public class SourceMain {
     public static void main(String[] args) {
        final double X = Double.parseDouble(args[0]);
        final int N = Integer.parseInt(args[1]);
        System.out.println(pow(X, N));
        System.out.println(pow2(X, N));
    }
}
