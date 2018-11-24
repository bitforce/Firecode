package source.lvl1.p17;

import static source.lvl1.p17.Source.singleNumber;
import static source.lvl1.p17.Source.singleNumber2;

public class SourceMain {
     public static void main(String[] args) {
        final int[] arr = new int[args.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        System.out.println(singleNumber(arr));
        System.out.println(singleNumber2(arr));
    }
}
