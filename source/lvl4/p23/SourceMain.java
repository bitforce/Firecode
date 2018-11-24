package source.lvl4.p23;

import java.util.ArrayList;

import static source.lvl4.p23.Source.insertRange;
import static source.lvl4.p23.Source.insertRange2;

public class SourceMain {
    public static void main(String[] args) {
        final ArrayList<Source.Interval> intervals = new ArrayList<>();
        for(int i = 2; i < args.length; i+=2) {
            int start = Integer.parseInt(args[i]);
            int end = Integer.parseInt(args[i+1]);
            intervals.add(new Source.Interval(start, end));
        }
        final int START = Integer.parseInt(args[0]);
        final int END = Integer.parseInt(args[1]);
        System.out.println(insertRange(intervals, new Source.Interval(START, END)));
        System.out.println(insertRange2(intervals, new Source.Interval(START, END)));
    }
}
