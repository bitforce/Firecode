package source.lvl2.p12;
class Source {
    /* ********************************************************************* */
    private static int[] selectionSortArray(int[] arr) {
        int min, temp;
        for(int i = 0; i < arr.length-1; i++) {
            min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min])
                    min = j;
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
    /* ********************************************************************* */
    private static int[] selectionSortArray2(int[] arr) {
        int head, tail, temp, len = arr.length;
        for(head = 0; head < len-1; head++)
            for(tail = head+1; tail < len; tail++) {
                if(arr[tail] < arr[head]) {
                    temp = arr[head];
                    arr[head] = arr[tail];
                    arr[tail] = temp;
                }
            }
        return arr;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for(int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        for(int i : selectionSortArray(arr))
            System.out.print(i + " ");
        System.out.println();
        for(int i : selectionSortArray2(arr))
            System.out.print(i + " ");
        System.out.println();
    }
}
