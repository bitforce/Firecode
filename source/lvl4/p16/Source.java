package source.lvl4.p16;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
        return 0;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        /*
         *                1
         *               2 3
         *              4 5 6
         *             7 8 9 10
         *
         * [[1], [2,3], [4,5,6], [7,8,9,10]]
         */
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        ArrayList<Integer> blist = new ArrayList<>();
        int k = 0;
        int m = 1;
        for(int i = 0; i < args.length; i++) {
            if(i + m > args.length) break;
            for(int j = i; j < i+m; j++) {
                System.out.println(j);
                blist.add(Integer.parseInt(args[j]));
                k++;
            }
            System.out.println();
            alist.add(new ArrayList<Integer>(blist));
            blist.clear();
            i = k-1;
            m++;
        }
        System.out.println(alist.toString());
        System.out.println(minTriangleDepth(alist));
    }
}
