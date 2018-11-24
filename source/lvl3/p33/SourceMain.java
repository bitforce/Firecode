package source.lvl3.p33;

import static source.lvl3.p33.Source.rotateLeft;

public class SourceMain {
     public static void main(String[] args) {
        final int[] arr = new int[args.length-1];
        for(int i = 0; i < args.length-1; i++)
            arr[i] = Integer.parseInt(args[i+1]);
        final int K = Integer.parseInt(args[0]);
        for(int i : rotateLeft(arr, K)) System.out.print(i + " ");
    }
}
