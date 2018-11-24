package source.lvl3.p06;

import java.util.ArrayList;

class Source {
    static ArrayList<String> combParenthesis(final int pairs) {
        final ArrayList<String> list = new ArrayList<>();
        if(pairs == 1) list.add("()");
        else {
            for(String s : combParenthesis(pairs-1)) {
                list.add(s+"()");
                list.add("("+s+")");
                if(!(s+"()").equals("()"+s))
                    list.add("()"+s);
            }
        }
        return list;
    }
}
