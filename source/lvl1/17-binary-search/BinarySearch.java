import java.util.*;

class BinarySearch {
    private static boolean binarySearch(int[] arr, int n) {
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(high >= low) {
            mid = (low + high) / 2;
            if(arr[mid] == n) return true;
            if(arr[mid] < n) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    private static boolean binarySearch2(int[] arr, int n) {
        if(arr.length == 0) return false;
        int mid = arr[arr.length/2];
        if(n < mid)
            return binarySearch(Arrays.copyOfRange
                    (arr, 0, arr.length/2), n);
        if(n > mid)
            return binarySearch(Arrays.copyOfRange
                    (arr, arr.length/2+1, arr.length), n);
        return mid == n;
    }
    public static void main(String[] args) {
        int[] arr = new int[args.length-1];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(args[i+1]);
        System.out.println(binarySearch(arr, Integer.parseInt(args[0])));
        System.out.println(binarySearch2(arr, Integer.parseInt(args[0])));
    }
}
