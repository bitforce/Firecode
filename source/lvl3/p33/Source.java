package source.lvl3.p33;

class Source {
    static int[] rotateLeft(final int[] arr, final int K) {
        if(arr == null || K < 1) return arr;
        for(int i = 0; i < K; i++)
            rotate(arr);
        return arr;
    }
    static void rotate(final int[] arr) {
        int i;
        final int temp = arr[0];
        for(i = 0; i < arr.length-1; i++)
            arr[i] = arr[i+1];
        arr[i] = temp;
    }
}
