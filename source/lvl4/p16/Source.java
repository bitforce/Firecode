package source.lvl4.p16;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
        /*
         * Assume index i, all we have to do is look at i+=1 && i+=2 which 
         * will give us the adjacent pairs in the "tree". I believe we can 
         * do this in log time and even use a dp approach , but my concern 
         * is not know the values ahead.
         * 
         * Do note that you'll have to add +1 and +2 to the difference in 
         * position of the inner array. Example, 2->3||2->5, but we need 
         * to take the length of the row (=2), therefore 2-1 +1 or +2.
         *
         * Thinking it out:
         * 1->2, 1->3
         * two is less
         * 2->4, 2->5
         */
        for(ArrayList<Integer> a : input) { // you may wanna use simple for
            int k = a.size();
            for(int j = 0; j < a.size(); j++) {
                int l = j+k+1;
                int r = j+k+2;
                System.out.println(l + " " + r);
                k--;
            }
            System.out.println("----");
        }
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
            for(int j = i; j < i+m; j++) {
                blist.add(Integer.parseInt(args[j]));
                k++;
            }
            alist.add(new ArrayList<Integer>(blist));
            blist.clear();
            i = k-1;
            m++;
        }
        System.out.println(alist.toString());
        System.out.println(minTriangleDepth(alist));
    }
}
