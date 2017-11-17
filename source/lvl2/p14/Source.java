package source.lvl2.p14;
class Source {
   /* ********************************************************************** */ 
    private static String compressString(String text) {
        int count = 1;
        String compressed = "";
        while(text.length() > 1) {
            if(text.charAt(0) == text.charAt(1)) {
                text = text.substring(1, text.length());
                count++;
            } else {
                compressed += text.charAt(0) + "" + count;
                text = text.substring(1, text.length());
                count = 1;
            }
        }
        String x = compressed + text.charAt(0) + count; 
        return x.replaceAll("1", "");
    }
   /* ********************************************************************** */ 
    private static String compressString2(String text) {
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            count++;
            if (i+1 >= text.length() || text.charAt(i) != text.charAt(i+1)) {
                builder.append(text.charAt(i));
                if (count > 1)
                    builder.append(count);
                count = 0;
            }
        }
        return builder.toString();
    }
   /* ********************************************************************** */ 
    private static String compressString3(String text) {
        if (text == null || text.length() < 2) return text;
        String head = text.substring(0, 1);
        String tail = text.substring(1);
        int count = 1;
        while (tail.length() > 0 && head.equals(tail.substring(0,1))) {
            count++;
            tail = tail.substring(1);
        }
        return count > 1 
            ? head + Integer.toString(count) + compressString3(tail)
            : head + compressString3(tail);
    }
   /* ********************************************************************** */ 
    public static void main(String[] args) {
        System.out.println(compressString(args[0]));
        System.out.println(compressString2(args[0]));
        System.out.println(compressString3(args[0]));
    }
}
