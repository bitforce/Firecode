class ReplaceAllSpaces {
    private static String replace(String a, String b) {
        String r = "";
        String[] arr = a.split(" ");
        for (String s : arr)
            r += (s + b);
        return r.substring(0, r.length()-b.length());
    }
    public static void main(String[] args) {
        System.out.println(replace(args[0], args[1]));
    }
}
