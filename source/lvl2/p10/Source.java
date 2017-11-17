package source.lvl2.p10;
import java.util.*;
class Source {
   /* ********************************************************************** */ 
    private static ArrayList<String> removeDuplicates(List<String> input) {
        Set<String> set = new HashSet<>(input);
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
   /* ********************************************************************** */ 
    private static ArrayList<String> removeDuplicates2(List<String> input) {
        TreeSet<String> set = new TreeSet<>(input);
        return new ArrayList<String>(set);
    }
   /* ********************************************************************** */ 
    private static ArrayList<String> removeDuplicates3(List<String> input) {
        return new ArrayList<String>(new TreeSet<String>(input));
    }
   /* ********************************************************************** */ 
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for(String s : args)
           list.add(s);
        System.out.println(removeDuplicates(list));
        System.out.println(removeDuplicates2(list));
        System.out.println(removeDuplicates3(list));
    }
}
