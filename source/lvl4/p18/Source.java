package source.lvl4.p18;

class Source {
    static boolean groupSum(final int[] arr, final int TARGET) {
        return groupSum(arr, arr.length, TARGET);
    }
    private static boolean groupSum(final int[] arr, final int len, final int TARGET) {
        if(TARGET == 0) return true;
        if(len == 0) return false;
        if(arr[len-1] > TARGET) return groupSum(arr, len-1, TARGET);
        return groupSum(arr, len-1, TARGET) || groupSum(arr, len-1, TARGET-arr[len-1]);
    }
    /* ********************************************************************* */
    static boolean groupSum2(final int[] arr, final int TARGET) {
        return groupSum2(0, arr, TARGET);
    }
    private static boolean groupSum2(final int start, final int[] arr, final int TARGET) {
        if(start >= arr.length) return TARGET == 0;
        else {
            if(groupSum2(start+1, arr, TARGET-arr[start])) return true;
            return groupSum2(start + 1, arr, TARGET);
        }
    }
    /* ********************************************************************* */
    static boolean groupSum3(final int[] arr, final int TARGET) {
        final boolean[] T = new boolean[TARGET+1];
        boolean[] Tnext = new boolean[TARGET+1];
        T[0] = true;
        int currMax = 0;
        int globMax = 0;
        for (int anArr : arr) {
            for (int j = 1; j < TARGET + 1 && j <= globMax + anArr; j++) {
                Tnext[j] = j >= anArr && T[j - anArr];
                currMax = Math.max(j, currMax);
            }
            for (int j = 0; j < TARGET + 1 && j <= globMax + anArr; j++)
                T[j] = T[j] || Tnext[j];
            globMax = currMax;
            Tnext = new boolean[TARGET + 1];
        }
        return T[TARGET];
    }
}
