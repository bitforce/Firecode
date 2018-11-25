package source.lvl5.p11;
import java.util.*;
class Source {
    static boolean splitArray(final int[] arr) {
        int sum = 0;
        for (int anArr : arr) sum += anArr;
        if(sum % 2 != 0) return false;
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
        return !(new HashSet<>(addedSubsetVals).size() == addedSubsetVals.size());
    }
    /* ********************************************************************* */
    private static boolean splitArray2(final int[] arr) {
        if (arr.length == 0)
           return false;
        int arr_sum = 0;
        for (int item : arr)
            arr_sum += item;
        if (arr_sum % 2 != 0) 
            return false;
        return groupSum(0, arr, arr_sum/2);
    }

    private static boolean groupSum(final int START_INDEX, final int[] arr, final int TARGET) {
        if (START_INDEX >= arr.length)
            return (TARGET == 0);
        if (groupSum(START_INDEX+1,arr,TARGET-arr[START_INDEX]))
            return true;
        return groupSum(START_INDEX + 1, arr, TARGET);
    }
    /* ********************************************************************* */
    private static boolean splitArray3(int[] arr) {
        return arr.length != 0 && splitArray(arr, 0, 0, 0);
    }

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
