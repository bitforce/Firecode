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
        int shift = args.length - 1;
        int j;
        for(int i = 0; i < args.length; i++) {
            for(j = i; j < args.length-shift; j++) {
                // figure out how to extract correct values
                blist.add(Integer.parseInt(args[j]));
            }
            System.out.println(blist.toString());
            /*
             * Because you are adding an object (addr) and not the vals alone, 
             * you can't simply just add 'blist', because each new iteration 
             * will change the vals and update all previous enters; thus, 
             * making the ArrayList uniform in element vals. So, we 
             * create a new ArrayList object everytime with the 
             * current vals of 'blist'.
             */
            alist.add(new ArrayList<Integer>(blist));
            shift-=2;
            if(shift < 0) break;
            blist.clear();
        }
        System.out.println(alist.toString());
        System.out.println(minTriangleDepth(alist));
    }
}
