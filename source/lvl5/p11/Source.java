package source.lvl5.p11;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static boolean splitArray(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) 
            sum += arr[i];
        if(sum % 2 != 0) 
            return false;
        final ArrayList<Integer> addedSubsetVals = new ArrayList<>();
        for(int i = 0; i < (1 << arr.length) - 1; i++) {
            int index = arr.length - 1;
            sum = 0;
            int num = i;
            while(num > 0) {
                if((num & 1) == 1)
                    sum += arr[index];
                index--;
                num >>= 1;
            }
            addedSubsetVals.add(sum);
        }
        return !(new HashSet<Integer>(addedSubsetVals).size() == addedSubsetVals.size());
    }
    /* ********************************************************************* */
    private static boolean splitArray2(int[] arr) {
        if (arr.length == 0)
           return false;
        int arr_sum = 0;
        for (int item : arr) 
            arr_sum += item;
        if (arr_sum % 2 != 0) 
            return false;
        return groupSum(0, arr, arr_sum/2);
    }

    private static boolean groupSum(int start_index, int[] arr, int target) {
        if (start_index >= arr.length)
            return (target == 0);
        if (groupSum(start_index+1,arr,target-arr[start_index]))
            return true;
        if (groupSum(start_index+1,arr,target))
            return true;
        return false;
    }
    /* ********************************************************************* */
    private static boolean splitArray3(int[] arr) {return arr.length == 0 ? false : splitArray(arr, 0,0,0);}

    private static boolean splitArray(int arr[], int leftVal, int rightVal, int position) {
        if(position < arr.length)
            return splitArray(arr, leftVal+arr[position], rightVal, position+1) 
                || splitArray(arr, leftVal, rightVal+arr[position], position+1);
        else if(position==arr.length && leftVal==rightVal) return true;
        else return false;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int[] ARR = new int[args.length];
        for(int i = 0; i < args.length; i++)
            ARR[i] = Integer.parseInt(args[i]);
        System.out.println(splitArray(ARR));
        System.out.println(splitArray2(ARR));
        System.out.println(splitArray3(ARR));
    }
}
