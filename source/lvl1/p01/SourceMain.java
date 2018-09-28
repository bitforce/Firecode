package source.lvl1.p01;
class SourceMain {
    public static void main(String[] args) {
        final int[] arr = new int[args.length];
        for (int i = 0 ; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        for (int i : Source.bubbleSortArray(arr))
            System.out.print(i + " ");
        System.out.println();
    }
}
