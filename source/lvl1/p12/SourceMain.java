package source.lvl1.p12;

import static source.lvl1.p12.Source.binarySearch;
import static source.lvl1.p12.Source.binarySearch2;

public class SourceMain {
    public static void main(String[] args) {
        int[] arr = new int[args.length-1];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(args[i+1]);
        final int N = Integer.parseInt(args[0]);
        System.out.println(binarySearch(arr, N));
        System.out.println(binarySearch2(arr, N));
    }
}
