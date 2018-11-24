package source.lvl2.p28;

import java.util.HashMap;

class Source {
    static int[] coupleSum(int[] numbers, int target) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
            int diff = target - numbers[i];
            if(map.containsKey(diff))
                return new int[]{map.get(diff)+1, i+1};
        }
        return null;
    }
}
