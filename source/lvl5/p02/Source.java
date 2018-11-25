package source.lvl5.p02;

class Source {
    static boolean groupSumWithNum(final int[] arr, final int MUST_HAVE, final int TARGET) {
        return groupSumWithNum(0, arr, MUST_HAVE, TARGET);
    }
    
    private static boolean groupSumWithNum(final int START_INDEX, int[] arr, int MUST_HAVE, int TARGET) {
        if(START_INDEX >= arr.length)
            return TARGET == 0;
        if(arr[START_INDEX] == MUST_HAVE)
            return groupSumWithNum(START_INDEX+1,arr,MUST_HAVE,TARGET-MUST_HAVE);
        if(groupSumWithNum(START_INDEX+1,arr,MUST_HAVE,TARGET-arr[START_INDEX]))
            return true;
        if(groupSumWithNum(START_INDEX+1,arr,MUST_HAVE,TARGET))
            return true;
        return false;
    }
    /* ********************************************************************* */
    static boolean groupSumWithNum2(final int[] arr, final int MUST_HAVE, int target) {
        int from = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == MUST_HAVE) {
                int tmp = arr[0];
                arr[0] = arr[i];
                arr[i] = tmp;
                from = 1;
                target = target - MUST_HAVE;
                break;
            }
        }
        return groupSumWithNumHelper2(arr, from, target);
    }

    private static boolean groupSumWithNumHelper2(int[] arr, int from, int TARGET) {
        if (TARGET == 0) return true;
        if (from >= arr.length) return false;
        return groupSumWithNumHelper2(arr, from + 1, TARGET)
                || groupSumWithNumHelper2(arr, from + 1, TARGET - arr[from]);
    }
    /* ********************************************************************* */
    static boolean groupSumWithNum3(final int[] arr, final int MUST_HAVE, final int TARGET) {
        if ( arr == null || arr.length == 0) return false;
        return groupSumWithNumHelper3( arr, 0, MUST_HAVE, TARGET);
    }
    private static boolean groupSumWithNumHelper3(
            final int[] arr,
            final int INDEX,
            final int MUST_HAVE,
            final int TARGET) {
        if ( INDEX  >= arr.length) {
            if ( TARGET == 0) return true;
            else return false;
        }
        if ( arr[INDEX] == MUST_HAVE)
            return groupSumWithNumHelper3( arr, INDEX + 1, MUST_HAVE, TARGET - arr[INDEX]);
        return groupSumWithNumHelper3( arr, INDEX + 1, MUST_HAVE, TARGET - arr[INDEX])
                || groupSumWithNumHelper3( arr, INDEX +1, MUST_HAVE, TARGET);
    }
}
