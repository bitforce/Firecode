package source.lvl3.p41;

import java.util.ArrayList;
import java.util.Comparator;

class Source {
    /* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    /* ********************************************************************* */
    static ArrayList<Interval> mergeIntervals(final ArrayList<Interval> intervalsList) {
        if(intervalsList.isEmpty()) return intervalsList;
        final ArrayList<Interval> list = new ArrayList<>();
        final ArrayList<Interval> il = intervalsList;
        int t = 0;
        for(int i = 0; i < il.size(); i++) {
            t = i;
            while(i < il.size()-1 && il.get(i).end >= il.get(i+1).start) i++;
            if(il.get(t).end > il.get(i).end) list.add(il.get(t));
            else list.add(new Interval(il.get(t).start, il.get(i).end));
        }
        return list;
    }
    /* ********************************************************************* */
    static ArrayList<Interval> mergeIntervals2(final ArrayList<Interval> intervalsList) {
        if (intervalsList == null || intervalsList.size() < 2) return intervalsList;
        final ArrayList<Interval> out = new ArrayList<>();
        intervalsList.sort(Comparator.comparingInt(o -> o.start));
        Interval prev = intervalsList.get(0);
        for (int i = 1; i < intervalsList.size(); i++) {
            Interval cur = intervalsList.get(i);
            if (cur.start <= prev.end)
                prev = new Interval(prev.start, Math.max(cur.end, prev.end));
            else {
                out.add(prev);
                prev = cur;
            }
        }
        out.add(prev);
        return out;
    }
}
