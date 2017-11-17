package source.lvl1.p01;
class Source {
    /* ********************************************************************* */
    private static int[] bubbleSortArray(int[] arr) {
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
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0 ; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        for (int i : bubbleSortArray(arr))
            System.out.print(i + " ");
        System.out.println();
    }
}
