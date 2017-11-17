package source.lvl2.p13;
import java.util.*;
class Source {
   /* ********************************************************************** */ 
    private static int maxGain(int[] a) {
        int x = a[0], y = a[a.length-1];
        for(int i = 1; i < a.length; i++)
            if(a[i] > x) x = a[i];
        for(int i = a.length-2; i >= 0; i--)
            if(y <= x && y > a[i]) y = a[i];
        if(y == a[a.length-1]) y = x;
        return x - y;
    }
   /* ********************************************************************** */ 
    private static int maxGain2(int[] a) {
        int max = a[1] - a[0], min = a[0];
        for(int i = 1; i < a.length; i++) {
            if(a[i] - min > max) max = a[i] - min; 
            if(a[i] < min) min = a[i];
        }
        return max < 0 ? 0 : max;
    }
   /* ********************************************************************** */ 
    private static int maxGain3(int[] a) {
        if(a.length == 1) return 0;
        int max = 0, min = a[0];
        for(int i = 1; i < a.length; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i] - min);
        }
        return max;
    }
   /* ********************************************************************** */ 
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for(int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        System.out.println(maxGain(arr));
        System.out.println(maxGain2(arr));
        System.out.println(maxGain3(arr));
    }
}
