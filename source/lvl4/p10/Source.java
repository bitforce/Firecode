package source.lvl4.p10;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Source {
    /* ********************************************************************* */
    // 
    //1921682040 => doesn't work correctly for this
    /*
     * FAILED SOLUTION
     *
     * expected output: 1921682040
     * 19.216.82.040,
     * 192.16.82.040,
     * 192.168.2.040,
     * 192.168.20.40,
     * 192.168.204.0
     */
    static ArrayList<String> generateIPAddrs(final String s) {
        final ArrayList<ArrayList<String>> llist = new ArrayList<>();
        final ArrayList<String> addrs = new ArrayList<>();
        dfs(llist, new ArrayList<String>(), s, 0);
        for(ArrayList<String> list : llist) {
            StringBuilder sb = new StringBuilder();
            for(String str : list) sb.append(str + ".");
            sb.setLength(sb.length()-1);
            addrs.add(sb.toString());
        }
        return addrs;
    }
    private static void dfs(
            final ArrayList<ArrayList<String>> ll,
            final ArrayList<String> l,
            final String s, int i) {
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
    static ArrayList<String> generateIPAddrs2(final String s) {
        class IpLevelNode {
            int lvl = 0;
            String pred;
            String succ;
            private IpLevelNode(int lvl, String ip, String pred, String succ) {
              this.lvl = lvl;
              this.succ = succ;
              if(lvl == 0) this.pred = ip;
              else this.pred = pred + "." + ip;
            }
        }
        final ArrayList<String> list = new ArrayList<>();
        final Deque<IpLevelNode> stack = new LinkedList<>();
        stack.addFirst(new IpLevelNode(0, s.substring(0,1), "", s.substring(1)));
        stack.addFirst(new IpLevelNode(0, s.substring(0,2), "", s.substring(2)));
        stack.addFirst(new IpLevelNode(0, s.substring(0,3), "", s.substring(3)));
        while(!stack.isEmpty()) {
            final IpLevelNode node = stack.removeFirst();
            int curLvl = node.lvl;
            final String pred = node.pred;
            final String remaining = node.succ;
            if(curLvl == 3 && remaining.length() == 0){
                list.add(node.pred);
                continue;
            }
            int i = 1;
            while(i <= 3){
                if(remaining.length() < i) break;
                String ip = remaining.substring(0,i);
                String succ = remaining.substring(i);
                if(ip.length() > 0) {
                    int num = Integer.parseInt(ip);
                    if(num <= 255)
                        stack.addFirst(new IpLevelNode(curLvl+1,ip,pred,succ));
                }
                i++;
            }
        }
        return list;
    }
    /* ********************************************************************* */
    static ArrayList<String> generateIPAddrs3(final String s) {
        return generateIPAddrs3("", s, 0);
    }
    private static ArrayList<String> generateIPAddrs3(final String prefix, final String s, final int DOTS) {
        final ArrayList<String> list = new ArrayList<>();
        if (DOTS == 3) {
            if (s.length() <= 3 && Integer.valueOf(s) <= 255)
                list.add(prefix + s);
        } else for (int i = 1; i <= 3; i++) {
                    String subprefix = prefix + s.substring(0, i);
                    String[] split = subprefix.split("\\.");
                    if (s.length() <= i || split.length > 0 && 
                        Integer.valueOf(split[split.length-1])>255) break;
                    list.addAll(generateIPAddrs3(subprefix + ".", 
                                                 s.substring(i), DOTS + 1));
                } 
        return list;
    }
}
