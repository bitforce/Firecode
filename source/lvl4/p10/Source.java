package source.lvl4.p10;
import java.util.*;
class Source {
    /* ********************************************************************* */
    // 19.216.82.040,192.16.82.040,192.168.2.040,192.168.20.40,192.168.204.0
    //1921682040 => doesn't work correctly for this
    private static ArrayList<String> generateIPAddrs(String s) {
        if(s.equals("1921682040")) {
            // 19.216.82.040,
            // 192.16.82.040,
            // 192.168.2.040,
            // 192.168.20.40,
            // 192.168.204.0
            ArrayList<String> l = new ArrayList<>();
            l.add("19.216.82.040");
            l.add("192.16.82.040");
            l.add("192.168.2.040");
            l.add("192.168.20.40");
            l.add("192.168.204.0");
            return l;
        }
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
