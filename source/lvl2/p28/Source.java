package source.lvl2.p28;
import java.util.*;
class Source {
   /* ********************************************************************** */ 
    public static int[] coupleSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
            int diff = target - numbers[i];
            if(map.containsKey(diff))
                return new int[]{map.get(diff)+1, i+1};
        }
        return null;
    }
   /* ********************************************************************** */ 
    public static void main(String[] args) {
        int target = Integer.parseInt(args[0]);
        int[] array = new int[args.length-1];
        for(int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(args[i+1]);
        try {
            for(int i : coupleSum(array, target))
                System.out.print(i + " ");
            System.out.println();
        } catch(Exception e) {System.out.println(e.getCause());}
    }
}
