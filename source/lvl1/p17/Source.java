package source.lvl1.p17;

import java.util.Arrays;
import java.util.HashMap;

class Source {
    static int singleNumber(int[] A) {
        if(A.length == 1) return A[0];
        Arrays.sort(A);
        if(A[0] != A[1]) return A[0];
        if(A[A.length-1] != A[A.length-2]) return A[A.length-1];
        int i = 0;
        int j = 1;
        int count = 0;
        int len = A.length;
        while(count < len) {
            if(A[i] == A[j]) {
                i++;
                j++;
            } else if(A[j] == A[j+1]) {
                i++;
                j++;
            } else return A[j];
        }
        return Integer.MIN_VALUE;
    }
    /* ********************************************************************* */
    static int singleNumber2(int[] A) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int aA : A)
            if (!map.containsKey(aA)) map.put(aA, 1);
            else map.put(aA, map.get(aA) + 1);
        for (int aA : A) if (map.get(aA) == 1) return aA;
        return Integer.MIN_VALUE;
    }
}
