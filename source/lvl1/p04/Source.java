package source.lvl1.p04;

class Source {
    static String replace(String a, String b) {
        StringBuilder r = new StringBuilder();
        String[] arr = a.split(" ");
        for (String s : arr)
            r.append(s).append(b);
        return r.substring(0, r.length()-b.length());
    }
}
