package source.lvl2.p28;

import java.util.Objects;

import static source.lvl2.p28.Source.coupleSum;

public class SourceMain {
     public static void main(String[] args) {
        int target = Integer.parseInt(args[0]);
        int[] array = new int[args.length-1];
        for(int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(args[i+1]);
        try {
            for(int i : Objects.requireNonNull(coupleSum(array, target)))
                System.out.print(i + " ");
            System.out.println();
        } catch(Exception e) {e.getCause();}
    }
}
