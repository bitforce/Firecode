package source.lvl5.p02;

import static source.lvl5.p02.Source.groupSumWithNum;
import static source.lvl5.p02.Source.groupSumWithNum2;
import static source.lvl5.p02.Source.groupSumWithNum3;

public class SourceMain {
     public static void main(String[] args) {
        final int MUST_HAVE = Integer.parseInt(args[0]);
        final int TARGET = Integer.parseInt(args[1]);
        final int SIZE = args.length-2;
        final int[] arr = new int[SIZE];
        for(int i = 0; i < SIZE; i++)
            arr[i] = Integer.parseInt(args[i+2]);
        System.out.println(groupSumWithNum(arr, MUST_HAVE, TARGET));
        System.out.println(groupSumWithNum2(arr, MUST_HAVE, TARGET));
        System.out.println(groupSumWithNum3(arr, MUST_HAVE, TARGET));
    }
}
