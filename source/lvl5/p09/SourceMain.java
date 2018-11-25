package source.lvl5.p09;

import static source.lvl5.p09.Source.maxContSequence;
import static source.lvl5.p09.Source.maxContSequence2;
import static source.lvl5.p09.Source.maxContSequence3;

public class SourceMain {
    public static void main(String[] args) {
        final int[] ARR = new int[args.length];
        for(int i = 0; i < ARR.length; i++)
            ARR[i] = Integer.parseInt(args[i]);

        for(int i : maxContSequence(ARR))
            System.out.print(i + " ");
        System.out.println();
        for(int i : maxContSequence2(ARR))
            System.out.print(i + " ");
        System.out.println();
        for(int i : maxContSequence3(ARR))
            System.out.print(i + " ");
        System.out.println();

    }
}
