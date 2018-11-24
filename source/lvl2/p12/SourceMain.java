package source.lvl2.p12;

import static source.lvl2.p12.Source.selectionSortArray;
import static source.lvl2.p12.Source.selectionSortArray2;

public class SourceMain {
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for(int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        for(int i : selectionSortArray(arr))
            System.out.print(i + " ");
        System.out.println();
        for(int i : selectionSortArray2(arr))
            System.out.print(i + " ");
        System.out.println();
    }
}
