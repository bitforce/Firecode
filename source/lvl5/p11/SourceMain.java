package source.lvl5.p11;

import static source.lvl5.p11.Source.splitArray;
import static source.lvl5.p11.Source.splitArray2;
import static source.lvl5.p11.Source.splitArray3;

public class SourceMain {
     public static void main(String[] args) {
        final int[] ARR = new int[args.length];
        for(int i = 0; i < args.length; i++)
            ARR[i] = Integer.parseInt(args[i]);
        System.out.println(splitArray(ARR));
        System.out.println(splitArray2(ARR));
        System.out.println(splitArray3(ARR));
    }
}
