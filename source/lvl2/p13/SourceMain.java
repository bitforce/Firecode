package source.lvl2.p13;

import static source.lvl2.p13.Source.maxGain;
import static source.lvl2.p13.Source.maxGain2;
import static source.lvl2.p13.Source.maxGain3;

public class SourceMain {
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for(int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        System.out.println(maxGain(arr));
        System.out.println(maxGain2(arr));
        System.out.println(maxGain3(arr));
    }
}
