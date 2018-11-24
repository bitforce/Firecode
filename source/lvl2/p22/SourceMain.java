package source.lvl2.p22;

import static source.lvl2.p22.Source.merge;
import static source.lvl2.p22.Source.merge2;

public class SourceMain {
     public static void main(String[] args) {
        final int llen = Integer.parseInt(args[0]);
        final int rlen = Integer.parseInt(args[llen+1]);
        final int[] left = new int[llen];
        final int[] right = new int[rlen];
        for(int i = 0; i < llen; i++)
            left[i] = Integer.parseInt(args[i+1]);
        for(int i = 0; i < rlen; i++)
            right[i] = Integer.parseInt(args[i+1+rlen]);
        for (int i : merge(left, right))
            System.out.print(i + " ");
        System.out.println();
        for (int i : merge2(left, right))
            System.out.print(i + " ");
        System.out.println();
    }
}
