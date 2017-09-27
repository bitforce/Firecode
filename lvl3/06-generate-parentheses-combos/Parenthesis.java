import java.util.*;

class Parenthesis {
    /* ********************************************************************* */
    private static ArrayList<String> combParenthesis(int pairs) {
        ArrayList<String> list = new ArrayList<>();
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
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(combParenthesis(Integer.parseInt(args[0])));
    }
}
