package source.lvl3.p31;

import static source.lvl3.p31.Source.getMaximumRepetition;

public class SourceMain {
     public static void main(String[] args) {
        int[] a = new int[args.length];
        for(int i = 0; i < args.length; i++)
            a[i] = Integer.parseInt(args[i]);
        System.out.println(getMaximumRepetition(a));
    }
}
