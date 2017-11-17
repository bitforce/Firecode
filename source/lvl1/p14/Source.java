package source.lvl1.p14;
class Source {
    /* ********************************************************************* */
    public static String reverseString(String str) {
        if(str == null)
            return null;
        if(str.equals(""))
            return "";
        String inputString = str;
        String outputString = null;
        outputString = "";
        for (int i = str.length() - 1; i > -1; i--)
            outputString += str.charAt(i);
        return outputString;
    }
    /* ********************************************************************* */
    public static String reverseString2(String str) {
        if(str == null) return null;
        if(str.length() == 0) return "";
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(reverseString(args[0]));
        System.out.println(reverseString2(args[0]));
    }
}
