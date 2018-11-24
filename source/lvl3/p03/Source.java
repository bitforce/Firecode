package source.lvl3.p03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Source {
    /* ********************************************************************* */
    private static final ArrayList<Integer> track = new ArrayList<>();
    static boolean isHappyNumber(int n) {
        if (n == 1 || n % 10 == 1) return true;
        track.add(n);
        ArrayList<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add((n % 10) * (n % 10));
            n /= 10;
        }
        int num = 0;
        for (int i : list)
            num += i;
        for (Integer aTrack : track)
            if (aTrack == num)
                return false;
        return isHappyNumber(num);
    }
    /* ********************************************************************* */
    private static final HashSet<Integer> set = new HashSet<>();
    static boolean isHappyNumber2(int n) {
        if (n == 1 || n % 10 == 1) return true;
        if (set.contains(n)) return false;
        set.add(n);
        final String val = String.valueOf(n);
        int m = 0;
        for(int i = 0; i < val.length(); i++) {
            int num = val.charAt(i) - '0';
            m += num * num;
        }
        return isHappyNumber2(m);
    }
    /* ********************************************************************* */
    static boolean isHappyNumber3(int n) {
        if (n == 1) return true;
        final Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (n != 1) {
            if (set.contains(n)) return false;
            set.add(n);
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
            sum = 0;
        }
        return true;
    }
}
