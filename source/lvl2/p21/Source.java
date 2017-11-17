package source.lvl2.p21;
class Source {
   /* ********************************************************************** */ 
    private static boolean isAnagram(String a, String b) {
        if((a == null || b == null) || (a.length() != b.length())) 
            return false;
        int asum = 0;
        int bsum = 0;
        for(int i = 0 ; i < a.length(); i++) {
            asum += (int) a.charAt(i);
            bsum += (int) b.charAt(i);
        }
        return asum == bsum;
    }
   /* ********************************************************************** */ 
    public static void main(String[] args) {
        System.out.println(isAnagram(args[0], args[1]));
    }
}
