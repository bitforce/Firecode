package source.lvl4.p23;

import java.util.ArrayList;

class Source {
    /* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
    static class Interval {
        int start;
        int end;
        Interval(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {return "[" + start + ", " + end + "]";}
    }
    /* ********************************************************************* */
    static ArrayList<Interval> insertRange(final ArrayList<Interval> intervalsList, final Interval insert) {
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
    static ArrayList<Interval> insertRange2(final ArrayList<Interval> intervalsList,  Interval insert) {
        final ArrayList<Interval> out = new ArrayList<>();
        for(Interval i: intervalsList){
            if(i.end < insert.start) {
                out.add(i);
            }
            else if(i.start > insert.end) {
                out.add(insert);
                insert = i;
            }
            else {
                int newStart = Math.min(i.start, insert.start);
                int newEnd = Math.max(i.end, insert.end);
                insert = new Interval(newStart, newEnd);
            }
        }
        out.add(insert);
        return out;
    }
}
