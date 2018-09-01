package source.lvl5.p09;
import java.util.*;
/**
 * Maxium Contiguous Subsequence: Kadane's Algorithm.
 */
class Source {
    /* ********************************************************************* */
    private static int[] maxContSequence(int[] arr) {
        if(arr == null) return null;
        int max = arr.length == 0 ? 0 : Integer.MIN_VALUE;
        int startIndex = 0;
        int tempStart = 0;
        int endIndex = -1;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
            if (max < temp) {
                max = temp;
                startIndex = tempStart;
                endIndex = i;
            }
            if (temp < 0) {
                temp = 0;
                tempStart = i + 1;
            }
        }
        return new int[]{max, startIndex, endIndex};
    }
    /* ********************************************************************* */
    public static int[] maxContSequence2(int[] arr) {
        int curr_starting_index = 0;
        int curr_ending_index = 0;
        int curr_sum = 0;
        int max_starting_index = 0;
        int max_ending_index = -1;
        int max_sum = 0;
        if(arr.length > 0) {
            curr_sum = arr[0];
            max_sum = arr[0];
            max_ending_index = 0;
          }
        for (int i = 1; i < arr.length; i++) {
            int sum = arr[i] + curr_sum;
            if (arr[i] > sum) {
                curr_starting_index = i;
                curr_ending_index = i;
                curr_sum = arr[i];    }
            else {
                curr_ending_index++;
                curr_sum += arr[i];   
            }
            if (curr_sum > max_sum) {
                max_sum = curr_sum;
                max_starting_index = curr_starting_index;
                max_ending_index = curr_ending_index;
            }
        }
        return new int[]{max_sum, max_starting_index, max_ending_index};
    }
    /* ********************************************************************* */
    public static int[] maxContSequence3(int[] arr) {
        if(arr == null) return null;
        if(arr.length < 1) return new int[]{0,0,-1};
        int max = arr[0];
        int startIndex = 0;
        int endIndex = 0;
        int sumTillNow = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(sumTillNow > 0 ) {
                sumTillNow += arr[i];
                if (sumTillNow > max) {
                    max = sumTillNow;
                    endIndex = i;
                }
            } else if(sumTillNow < 0 && arr[i] > sumTillNow) {
                sumTillNow = arr[i];
                if (sumTillNow > max){
                    max = sumTillNow;
                    startIndex = i;
                    endIndex = i;
                }
            }
        }
        return new int[]{max, startIndex, endIndex};
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int[] ARR = new int[args.length];
        for(int i = 0; i < ARR.length; i++)
            ARR[i] = Integer.parseInt(args[i]);

        for(int i : maxContSequence(ARR))
            System.out.print(i + " ");
        System.out.println();
        for(int i : maxContSequence2(ARR))
            System.out.print(i + " ");
        System.out.println();
        for(int i : maxContSequence2(ARR))
            System.out.print(i + " ");
        System.out.println();

    }
}
