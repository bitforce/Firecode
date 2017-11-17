package source.lvl1.p09;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static String duplicate(int[] numbers) {
        if(numbers == null || numbers.length < 3) return "[]";
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++)
            for(int j = 0; j < numbers.length; j++)
                if(numbers[i] == numbers[j] && i != j && 
                   !list.contains(numbers[i])) {
                    list.add(numbers[i]);
                    break;
                } 
        return list.toString();
    }
    /* ********************************************************************* */
    private static String duplicate2(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.sort(numbers);
        for(int i = 1; i < numbers.length; i++)
            if(numbers[i] == numbers[i-1])
                set.add(numbers[i]);
        return set.toString();
    }
    /* ********************************************************************* */
    private static String duplicate3(int[] numbers) {
        Set<Integer> map = new HashSet<>();
        Set<Integer> list = new TreeSet<>();
        for(int num : numbers)
            if(map.contains(num)) list.add(num);
            else map.add(num);
        return list.toString();
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] array = new int[args.length];
        for(int i = 0; i < args.length; i++)
            array[i] = Integer.parseInt(args[i]);
        System.out.println(duplicate(array));
        System.out.println(duplicate2(array));
        System.out.println(duplicate3(array));
    }
}
