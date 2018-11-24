package source.lvl1.p14;

class Source {
    static String reverseString(String str) {
        if(str == null)
            return null;
        if(str.equals(""))
            return "";
        final StringBuilder outputString = new StringBuilder();
        for (int i = str.length() - 1; i > -1; i--)
            outputString.append(str.charAt(i));
        return outputString.toString();
    }
    /* ********************************************************************* */
    static String reverseString2(String str) {
        if(str == null) return null;
        if(str.length() == 0) return "";
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
