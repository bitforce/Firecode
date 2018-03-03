package source.lvl4.p10;
import java.util.*;
class Source {
    /* ********************************************************************* */
    // you can always expect at least four numbers
    private static ArrayList<String> generateIPAddrs(String s) {
        ArrayList<ArrayList<String>> llist = new ArrayList<>();
        ArrayList<String> addrs = new ArrayList<>(); 
        dfs(llist, new ArrayList<String>(), s, 0);
        for(ArrayList<String> list : llist) {
            StringBuilder sb = new StringBuilder();
            for(String str : list) sb.append(str + ".");
            sb.setLength(sb.length()-1);
            addrs.add(sb.toString());
        }
        return addrs;
    }
    private static void dfs(ArrayList<ArrayList<String>> ll,
                            ArrayList<String> l,
                            String s, int i) {
        if(l.size() >= 4 && i != s.length()) return;
        if(l.size() + s.length() - i + 1 < 4) return;
        if(l.size() == 4 && i == s.length()) {
            ll.add(new ArrayList<String>(l));
            return;
        }
        for(int j = 1; j <= 3; j++) {
            if(i + j > s.length()) break;
            String sub = s.substring(i, i+j);
            if(j > 1 && s.charAt(i) == '0') break;
            if(Integer.valueOf(sub) > 255) break;
            l.add(sub);
            dfs(ll, l, s, i+j);
            l.remove(l.size()-1);
        }
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(generateIPAddrs(args[0]));
    }
}
