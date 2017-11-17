package source.lvl1.p06;
class Source {
    /* ********************************************************************* */
    public static int findMissingNumber(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];
        return 55 - sum;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        System.out.println(findMissingNumber(arr));
    }
}
