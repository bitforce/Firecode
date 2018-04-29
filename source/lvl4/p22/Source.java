package source.lvl4.p22;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static ArrayList<String> getCombPerms(String s) {
        if(s == null) return null;
        ArrayList<String> list = new ArrayList<>();
        if(s.length() == 1) {
            list.add(s);
            return list;
        }
        String first = s.substring(0,1);
        list.add(first);
        String remainder = s.substring(1);
        ArrayList<String> words = getCombPerms(remainder);
        for(String word : words)
            for(int i = 0; i <= word.length(); i++)
                list.add(insertCharAt(word, first, i));
        list.addAll(words);
        return list;
    }
    private static String insertCharAt(String s, String c, int i) {
        String start = s.substring(0,i);
        String end = s.substring(i);
        return start + c + end;
    }
    public static ArrayList<String> getCombPerms3(String s) {
        if (s == null || s.length() == 0) return null;
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        for (char c : s.toCharArray()) {
            ArrayList<String> newList = new ArrayList<>();
            for (String pre : list)
                for (int i = 0; i <= pre.length(); i++)
                    newList.add(pre.substring(0, i) + c + pre.substring(i));
            list.addAll(newList);
        }
        list.remove(0);
        return list;
    }
    /* ********************************************************************* */
    private static ArrayList<String> getCombPerms2(String s) {
        if(s == null) return null;
        ArrayList<String> list = new ArrayList<>();
        getCombPerms2("", s, list);
        return list;
    }
    private static void getCombPerms2(String prefix, String s, ArrayList<String> list) {
        if(!prefix.isEmpty()) list.add(prefix);
        for(int i = 0; i < s.length(); i++)
            getCombPerms2(prefix+s.charAt(i), s.substring(0,i) + s.substring(i+1), list);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(getCombPerms(args[0]));
        System.out.println(getCombPerms2(args[0]));
        System.out.println(getCombPerms3(args[0]));
    }
}
