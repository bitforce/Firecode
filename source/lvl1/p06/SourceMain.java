package source.lvl1.p06;

import static source.lvl1.p06.Source.findMissingNumber;
import static source.lvl1.p06.Source.findMissingNumber2;

public class SourceMain {
     public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        System.out.println(findMissingNumber(arr));
        System.out.println(findMissingNumber2(arr));
    }
}
