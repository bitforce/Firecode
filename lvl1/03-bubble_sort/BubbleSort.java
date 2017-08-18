class BubbleSort {
    private static int[] bubbleSortArray(int[] arr) {
        int len = arr.length;
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++)
            for (int j = 1; j < len-i; j++)
                if (arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0 ; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        for (int i : bubbleSortArray(arr))
            System.out.print(i + " ");
        System.out.println();
    }
}
