package source.lvl2.p10;

import java.util.*;

class Source {
    static ArrayList<String> removeDuplicates(List<String> input) {
        final Set<String> set = new HashSet<>(input);
        final ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
   /* ********************************************************************** */ 
    static ArrayList<String> removeDuplicates2(List<String> input) {
        final TreeSet<String> set = new TreeSet<>(input);
        return new ArrayList<>(set);
    }
   /* ********************************************************************** */ 
    static ArrayList<String> removeDuplicates3(List<String> input) {
        return new ArrayList<>(new TreeSet<>(input));
    }
}
