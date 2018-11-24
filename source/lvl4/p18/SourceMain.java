package source.lvl4.p18;

import static source.lvl4.p18.Source.groupSum;
import static source.lvl4.p18.Source.groupSum2;
import static source.lvl4.p18.Source.groupSum3;

public class SourceMain {
    public static void main(String[] args) {
        final int TARGET = Integer.parseInt(args[0]);
        final int[] arr = new int[args.length-1];
        for(int i = 0; i < args.length-1; i++)
            arr[i] = Integer.parseInt(args[i+1]);
        System.out.println(groupSum(arr, TARGET));
        System.out.println(groupSum2(arr, TARGET));
        System.out.println(groupSum3(arr, TARGET));
    }
}
