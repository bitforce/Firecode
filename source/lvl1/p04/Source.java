package source.lvl1.p04;
class Source {
    /* ********************************************************************* */
    private static String replace(String a, String b) {
        String r = "";
        String[] arr = a.split(" ");
        for (String s : arr)
            r += (s + b);
        return r.substring(0, r.length()-b.length());
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        String a = "";
        for(String s : args) a += s + " ";
        a = a.substring(0, a.length()-2);
        System.out.println(replace(a, args[args.length-1]));
    }
}
