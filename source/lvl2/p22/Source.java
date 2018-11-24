package source.lvl2.p22;

import java.util.Arrays;

class Source {
    static int[] merge(int[] left, int[] right) {
        if(left.length == 0) return right;
        if(right.length == 0) return left;
        int[] both = new int[left.length + right.length];
        System.arraycopy(left, 0, both, 0, left.length);
        System.arraycopy(right, 0, both, left.length, right.length);
        Arrays.sort(both);
        return both;
    }
   /* ********************************************************************** */ 
    static int[] merge2(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int mindex = 0;
        int lindex = 0;
        int rindex = 0;
        while (lindex < left.length && rindex < right.length) {
            if (left[lindex] < right[rindex]) {
                merged[mindex++] = left[lindex];
                lindex++;
            } else {
                merged[mindex++] = right[rindex];
                rindex++;
            }
        }
        while (lindex < left.length)
            merged[mindex++] = left[lindex++];
        while (rindex < right.length)
            merged[mindex++] = right[rindex++]; 
        return merged;
    }
} 
