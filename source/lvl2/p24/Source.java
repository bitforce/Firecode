package source.lvl2.p24;
class Source {
   /* ********************************************************************** */ 
    private static boolean permutation(String a, String b) {
        if(a != null && b != null)
            if(a.length() == b.length()) {
                int asum = 0;
                int bsum = 0;
                for(int i = 0; i < a.length(); i++)
                    asum += (int) a.charAt(i);
                for(int i = 0; i < b.length(); i++)
                    bsum += (int) b.charAt(i);
                return asum == bsum;
            }
        return false;
    }
   /* ********************************************************************** */ 
    public static boolean permutation2(String a, String b) {
        if(a == null || b == null || a.length() != b.length()) 
            return false;
        if(a.equals(b)) return true;
        char[] arr = new char[256];
        for(int i = 0; i < a.length(); i++){
            arr[a.charAt(i)]++;
            arr[b.charAt(i)]--;
        }
        for(int i=0; i<256; i++){
            if(arr[i] != 0)
                return false;
        }
        return true;
    }
   /* ********************************************************************** */ 
    public static void main(String[] args) {
        System.out.println(permutation(args[0], args[1]));
        System.out.println(permutation2(args[0], args[1]));
    }
}
