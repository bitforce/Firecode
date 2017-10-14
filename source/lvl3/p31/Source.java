package source.lvl3.p31;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static int getMaximumRepetition(int[] a) {
        int num = a.length;
        for(int i = 1; i < a.length; i++)
           a[a[i]%num] += num;
        int max = a[0];
        int ans = 0;
        for(int i = 1; i < a.length; i++)
            if(a[i] > max) {
                max = a[i];
                ans = i;
            }
        return ans;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] a = new int[args.length];
        for(int i = 0; i < args.length; i++)
            a[i] = Integer.parseInt(args[i]);
        System.out.println(getMaximumRepetition(a)); 
    }
}
