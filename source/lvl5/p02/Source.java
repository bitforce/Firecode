package source.lvl5.p02;
import java.util.stream.IntStream;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static boolean groupSumWithNum(int[] arr, int must_have, int target) {
        return groupSumWithNum(0, arr, must_have, target);
    }
    
    private static boolean groupSumWithNum(int start_index, int[] arr, int must_have, int target) {
        if(start_index >= arr.length) 
            return target == 0;
        if(arr[start_index] == must_have)
            return groupSumWithNum(start_index+1,arr,must_have,target-must_have);
        if(groupSumWithNum(start_index+1,arr,must_have,target-arr[start_index]))
            return true;
        if(groupSumWithNum(start_index+1,arr,must_have,target))
            return true;
        return false;
    }
    /* ********************************************************************* */
    public static boolean groupSumWithNum2(int[] arr, int must_have, int target) {
        int from = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == must_have) {
                int tmp = arr[0];
                arr[0] = arr[i];
                arr[i] = tmp;
                from = 1;
                target = target - must_have;
                break;
            }
        }
        return groupSumWithNumHelper2(arr, from, target);
    }

    private static boolean groupSumWithNumHelper2(int[] arr, int from, int target) {
        if (target == 0) return true;
        if (from >= arr.length) return false;
        return groupSumWithNumHelper2(arr, from + 1, target) || groupSumWithNumHelper2(arr, from + 1, target - arr[from]);
    }
    /* ********************************************************************* */
    public static boolean groupSumWithNum3(int[] arr, int must_have, int target) {
        if ( arr == null || arr.length == 0) return false;
        return groupSumWithNumHelper3( arr, 0, must_have, target);
    }
    public static boolean groupSumWithNumHelper3( int[] arr, int index, int must_have, int target) {
        if ( index  >= arr.length) {
            if ( target == 0) return true;
            else return false;
        }
        if ( arr[index] == must_have) return groupSumWithNumHelper3( arr, index + 1, must_have, target - arr[index]);
        return groupSumWithNumHelper3( arr, index + 1, must_have, target - arr[index]) || groupSumWithNumHelper3( arr, index +1, must_have, target);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int MUST_HAVE = Integer.parseInt(args[0]);
        final int TARGET = Integer.parseInt(args[1]);
        final int SIZE = args.length-2;
        final int[] arr = new int[SIZE];
        for(int i = 0; i < SIZE; i++)
            arr[i] = Integer.parseInt(args[i+2]);
        System.out.println(groupSumWithNum(arr, MUST_HAVE, TARGET));
        System.out.println(groupSumWithNum2(arr, MUST_HAVE, TARGET));
        System.out.println(groupSumWithNum3(arr, MUST_HAVE, TARGET));
    }
}
