package source.lvl1.p09;

import static source.lvl1.p09.Source.duplicate;
import static source.lvl1.p09.Source.duplicate2;
import static source.lvl1.p09.Source.duplicate3;

public class SourceMain {
     public static void main(String[] args) {
        int[] array = new int[args.length];
        for(int i = 0; i < args.length; i++)
            array[i] = Integer.parseInt(args[i]);
        System.out.println(duplicate(array));
        System.out.println(duplicate2(array));
        System.out.println(duplicate3(array));
    }
}
