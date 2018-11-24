package source.lvl4.p22;

import java.util.ArrayList;

class Source {
    static ArrayList<String> getCombPerms(final String s) {
        if(s == null) return null;
        final ArrayList<String> list = new ArrayList<>();
        if(s.length() == 1) {
            list.add(s);
            return list;
        }
        final String first = s.substring(0,1);
        list.add(first);
        final String remainder = s.substring(1);
        final ArrayList<String> words = getCombPerms(remainder);
        for(String word : words)
            for(int i = 0; i <= word.length(); i++)
                list.add(insertCharAt(word, first, i));
        list.addAll(words);
        return list;
    }
    private static String insertCharAt(final String s, final String c, final int I) {
        final String start = s.substring(0,I);
        final String end = s.substring(I);
        return start + c + end;
    }
    /* ********************************************************************* */
    static ArrayList<String> getCombPerms2(final String s) {
        if(s == null) return null;
        final ArrayList<String> list = new ArrayList<>();
        getCombPerms2("", s, list);
        return list;
    }
    private static void getCombPerms2(
            final String prefix,
            final String s,
            final ArrayList<String> list) {
        if(!prefix.isEmpty()) list.add(prefix);
        for(int i = 0; i < s.length(); i++)
            getCombPerms2(prefix+s.charAt(i), s.substring(0,i) + s.substring(i+1), list);
    }
    /* ********************************************************************* */
    static ArrayList<String> getCombPerms3(final String s) {
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
}
