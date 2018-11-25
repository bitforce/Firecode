package source.lvl5.p11;

import java.util.ArrayList;
import java.util.HashSet;

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
    static boolean splitArray2(final int[] arr) {
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
    static boolean splitArray3(final int[] arr) {
        return arr.length != 0 && splitArray(arr, 0, 0, 0);
    }
    private static boolean splitArray(final int arr[], final int LEFT_VAL, final int RIGHT_VAL, final int POSITION) {
        if(POSITION < arr.length)
            return splitArray(arr, LEFT_VAL+arr[POSITION], RIGHT_VAL, POSITION+1)
                || splitArray(arr, LEFT_VAL, RIGHT_VAL+arr[POSITION], POSITION+1);
        else return POSITION == arr.length && LEFT_VAL == RIGHT_VAL;
    }
}
