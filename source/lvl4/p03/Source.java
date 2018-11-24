package source.lvl4.p03;

import java.util.HashMap;

class Source {
    static int longestNRSubstringLen(final String input) {
        if(input == null || input.equals("")) return 0;
        final int[] visited = new int[256];
        int max = 1;
        int cur = 1;
        int prev;
        for(int i = 0; i < visited.length; i++)
            visited[i] = -1;
        for(int i = 1; i < input.length(); i++) {
            prev = visited[input.charAt(i)];
            if(prev == -1 || i - cur > prev)
                cur++;
            else {
                if(cur > max) max = cur;
                cur = i - prev;
            }
            visited[input.charAt(i)] = i;
        }
        return cur > max ? cur : max;
    }
    /* ********************************************************************* */
    static int longestNRSubstringLen2(String input) {
        if(input == null) return 0;
        final HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = input.toCharArray();
        int prev = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i]))
                map.put(arr[i], i);
            else {
                prev = Math.max(prev, map.size());
                i = map.get(arr[i]);
                map.clear();
            }
        }
        return Math.max(prev, map.size());
    }
    /* ********************************************************************* */
    static int longestNRSubstringLen3(String input) {
        if(input == null) return 0;
        int[] count = new int[256];
        int length = 0;
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < input.length()) {
            while(end < input.length() && count[input.charAt(end++)]++ < 1)
                length++;
            max = Math.max(length, end-start-1);
            while(count[input.charAt(start++)]-- > 1)
                length--;
        }
        return max;
    }
}
