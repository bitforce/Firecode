package source.lvl1.p06;

class Source {
    static int findMissingNumber(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];
        return 55 - sum;
    }
    /* ********************************************************************* */
    static int findMissingNumber2(int[] arr) {
        int arraySum = 0;
        int totalSum = 0;
        for(int i = 1; i <= arr.length+1; i++) totalSum += i;
        for(int i = 0; i < arr.length; i++) arraySum += arr[i];
        return totalSum ^ arraySum;
    }
}
