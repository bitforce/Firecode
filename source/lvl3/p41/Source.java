package source.lvl3.p41;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    /* ********************************************************************* */
    private static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervalsList) {
        if(intervalsList.isEmpty()) return intervalsList;
        ArrayList<Interval> list = new ArrayList<>();
        ArrayList<Interval> il = intervalsList;
        int start = Integer.MIN_VALUE;
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
    private static ArrayList<Interval> mergeIntervals2(ArrayList<Interval> intervalsList) {
        if (intervalsList == null || intervalsList.size() < 2) return intervalsList;
        ArrayList<Interval> out = new ArrayList<>();
        Collections.sort(intervalsList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
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
    /* ********************************************************************* */
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        int temp = Integer.MIN_VALUE;
        for(int i = 0 ; i < args.length; i++) {
            if(i % 2 != 0) list.add(new Interval(temp, Integer.parseInt(args[i])));
            else temp = Integer.parseInt(args[i]);
        }
        for(Interval i : list)
            System.out.print("[[" + i.start + "," + i.end + "]] ");
        System.out.println(); 
        for(Interval i : mergeIntervals(list))
            System.out.print("[[" + i.start + "," + i.end + "]] "); 
        System.out.println(); 
        for(Interval i : mergeIntervals2(list))
            System.out.print("[[" + i.start + "," + i.end + "]] "); 
        System.out.println();
    }
}
