package source.lvl1.p01;

import static source.lvl1.p01.Source.bubbleSortArray;

class SourceMain {
    public static void main(String[] args) {
        final int[] arr = new int[args.length];
        for (int i = 0 ; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        for (int i : bubbleSortArray(arr))
            System.out.print(i + " ");
        System.out.println();
    }
}
