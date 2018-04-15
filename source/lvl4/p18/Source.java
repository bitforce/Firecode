package source.lvl4.p18;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static boolean groupSum(int[] arr, int target) {return groupSum(arr, arr.length, target);}
    private static boolean groupSum(int[] arr, int len, int target) {
        if(target == 0) return true;
        if(len == 0 && target != 0) return false;
        if(arr[len-1] > target) return groupSum(arr, len-1, target);
        return groupSum(arr, len-1, target) || groupSum(arr, len-1, target-arr[len-1]);
    }
    /* ********************************************************************* */
    private static boolean groupSum2(int[] arr, int target) {return groupSum2(0, arr, target);}
    private static boolean groupSum2(int start, int[] arr, int target) {
        if(start >= arr.length) return target == 0;
        else {
            if(groupSum2(start+1, arr, target-arr[start])) return true;
            if(groupSum2(start+1, arr, target)) return true;
        }
        return false;
    }
    /* ********************************************************************* */
    private static boolean groupSum3(int[] arr, int target) {
        boolean[] T = new boolean[target+1];
        boolean[] Tnext = new boolean[target+1];
        T[0] = true;
        int currMax = 0;
        int globMax = 0;
        for(int i=0; i<arr.length;i++) {
            for(int j=1; j<target+1 && j<=globMax+arr[i]; j++){
                Tnext[j] = j>=arr[i] ? T[j-arr[i]] : false;
                currMax=Math.max(j,currMax);
            }
            for(int j=0; j<target+1 && j<=globMax+arr[i]; j++)
                T[j] = T[j] || Tnext[j];
            globMax = currMax;
            Tnext = new boolean[target+1];
        }
        return T[target];
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int TARGET = Integer.parseInt(args[0]);
        int[] arr = new int[args.length-1];
        for(int i = 0; i < args.length-1; i++)
            arr[i] = Integer.parseInt(args[i+1]);
        System.out.println(groupSum(arr, TARGET));
        System.out.println(groupSum2(arr, TARGET));
        System.out.println(groupSum3(arr, TARGET));
    }
}
