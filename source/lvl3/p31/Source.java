package source.lvl3.p31;

class Source {
    static int getMaximumRepetition(final int[] a) {
        final int num = a.length;
        for(int i = 1; i < a.length; i++)
           a[a[i]%num] += num;
        int max = a[0];
        int ans = 0;
        for(int i = 1; i < a.length; i++)
            if(a[i] > max) {
                max = a[i];
                ans = i;
            }
        return ans;
    }
}
