package source.lvl1.p01;
class Source {
    /* ********************************************************************* */
    static int[] bubbleSortArray(int[] arr) {
        if(arr == null) return null;
        final int LEN = arr.length;
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < LEN; i++)
            for (int j = 1; j < LEN-i; j++)
                if (arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
        return arr;
    }
    /* ********************************************************************* */
}
