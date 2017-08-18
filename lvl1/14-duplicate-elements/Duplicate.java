import java.util.*;

/**
 * ABSTRACT
 * ........
 * Write a method duplicate to find the repeated or duplicate elements in an 
 * array. This method should return a list of repeated integers in a string 
 * with the elements sorted in ascending order
 *
 * ----------------------------------------------------------------------------
 * N/A 
 */
class Duplicate {
    // O(n^2)
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
    // O(log(n))
    private static String duplicate2(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.sort(numbers);
        for(int i = 1; i < numbers.length; i++)
            if(numbers[i] == numbers[i-1])
                set.add(numbers[i]);
        return set.toString();
    }
    // O(log(n))
    private static String duplicate3(int[] numbers) {
        Set<Integer> map = new HashSet<>();
        Set<Integer> list = new TreeSet<>();
        for(int num : numbers)
            if(map.contains(num)) list.add(num);
            else map.add(num);
        return list.toString();
    }
    public static void main(String[] args) {
        int[] array = new int[args.length];
        for(int i = 0; i < args.length; i++)
            array[i] = Integer.parseInt(args[i]);
        System.out.println(duplicate(array));
        System.out.println(duplicate2(array));
        System.out.println(duplicate3(array));
    }
}
