package source.lvl4.p23;
import java.util.*;
class Source {
    private static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {return "[" + start + ", " + end + "]";}
    }
    /* ********************************************************************* */
    private static ArrayList<Interval> insertRange(ArrayList<Interval> intervalsList, Interval insert) {
        if (intervalsList == null || intervalsList.size() == 0 || insert == null) {
            if (insert != null) intervalsList.add(insert);
            return intervalsList;
        }
        int start = insert.start;
        int front = -1;
        for (int i = 0; i < intervalsList.size(); i++)
            if (intervalsList.get(i).start <= start)
                front = i;
        if (front == -1) intervalsList.add(0, insert);
        intervalsList.add(front + 1, insert);
        Interval previous = intervalsList.get(0);
        Interval current = null;
        for (int i = 1; i < intervalsList.size(); i++) {
            current = intervalsList.get(i);
            if (previous.end >= current.start) {
                previous.end = previous.end > current.end ? previous.end : current.end;
                intervalsList.remove(i);
                i--;
            } else previous = current;
        }
        return intervalsList;
    }
    /* ********************************************************************* */
    public static ArrayList<Interval> insertRange2(ArrayList<Interval> intervalsList, Interval insert) {
        ArrayList<Interval> out = new ArrayList<>();
        for(Interval i: intervalsList){
            if(i.end < insert.start) {
                out.add(i);
            }
            else if(i.start > insert.end) {
                out.add(insert);
                insert = i;
            }
            else if(i.start <= insert.end || i.end >= insert.start){
                int newStart = Math.min(i.start, insert.start);
                int newEnd = Math.max(i.end, insert.end);
                insert = new Interval(newStart, newEnd);
            }
        }
        out.add(insert);
        return out;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        for(int i = 2; i < args.length; i+=2) {
            int start = Integer.parseInt(args[i]);
            int end = Integer.parseInt(args[i+1]);
            intervals.add(new Interval(start, end));
        }
        int start = Integer.parseInt(args[0]);
        int end = Integer.parseInt(args[1]);
        System.out.println(insertRange(intervals, new Interval(start, end)));
        System.out.println(insertRange2(intervals, new Interval(start, end)));
    }
}
