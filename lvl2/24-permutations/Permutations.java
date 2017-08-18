import java.util.*;

class Permutations {
    private static boolean permuation(String a, String b) {
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
    public static void main(String[] args) {
        System.out.println(permuation(args[0], args[1]));
    }
}
