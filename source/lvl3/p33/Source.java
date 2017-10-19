package source.lvl3.p33;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static int[] rotateLeft(int[] arr, int k) {
        if(arr == null || k < 1) return arr;
        for(int i = 0; i < k; i++)
            rotate(arr);
        return arr;
    }
    private static void rotate(int[] arr) {
        int i;
        int temp = arr[0];
        for(i = 0; i < arr.length-1; i++)
            arr[i] = arr[i+1];
        arr[i] = temp;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] arr = new int[args.length-1];
        for(int i = 0; i < args.length-1; i++)
            arr[i] = Integer.parseInt(args[i+1]);
        int k = Integer.parseInt(args[0]);
        for(int i : rotateLeft(arr, k)) System.out.print(i + " ");
        System.out.println();
        for(int i : rotateLeft2(arr, k)) System.out.print(i + " ");
    }
}
