package source.lvl2.p12;

class Source {
    static int[] selectionSortArray(int[] arr) {
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
    static int[] selectionSortArray2(int[] arr) {
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
}
