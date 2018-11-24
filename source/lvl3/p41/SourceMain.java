package source.lvl3.p41;

import java.util.ArrayList;

import static source.lvl3.p41.Source.mergeIntervals;
import static source.lvl3.p41.Source.mergeIntervals2;

public class SourceMain {
    public static void main(String[] args) {
        final ArrayList<Source.Interval> list = new ArrayList<>();
        int temp = Integer.MIN_VALUE;
        for(int i = 0 ; i < args.length; i++) {
            if(i % 2 != 0) list.add(new Source.Interval(temp, Integer.parseInt(args[i])));
            else temp = Integer.parseInt(args[i]);
        }
        for(Source.Interval i : list)
            System.out.print("[[" + i.start + "," + i.end + "]] ");
        System.out.println();
        for(Source.Interval i : mergeIntervals(list))
            System.out.print("[[" + i.start + "," + i.end + "]] ");
        System.out.println();
        for(Source.Interval i : mergeIntervals2(list))
            System.out.print("[[" + i.start + "," + i.end + "]] ");
        System.out.println();
    }
}
