package source.lvl5.p11;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static boolean splitArray(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) sum += arr[i];
        if(sum % 2 != 0) return false;
        return false;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int[] ARR = new int[args.length];
        for(int i = 0; i < args.length; i++)
            ARR[i] = Integer.parseInt(args[i]);
        System.out.println(splitArray(ARR));
    }
}
