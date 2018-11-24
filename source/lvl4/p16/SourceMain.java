package source.lvl4.p16;

import java.util.ArrayList;

import static source.lvl4.p16.Source.minTriangleDepth;
import static source.lvl4.p16.Source.minTriangleDepth2;

public class SourceMain {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        ArrayList<Integer> blist = new ArrayList<>();
        int k = 0;
        int m = 1;
        for(int i = 0; i < args.length; i++) {
            for(int j = i; j < i+m; j++) {
                blist.add(Integer.parseInt(args[j]));
                k++;
            }
            alist.add(new ArrayList<>(blist));
            blist.clear();
            i = k-1;
            m++;
        }
        System.out.println(alist.toString());
        System.out.println(minTriangleDepth(alist));
        System.out.println(minTriangleDepth2(alist));
    }
}
