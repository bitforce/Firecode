package source.lvl5.p01;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private String longestPalSubstr(String str) {
        if(str == null || str.length() < 2) return str;
        final int STRING_SIZE = str.length();
        final boolean[][] table = new boolean[STRING_SIZE][STRING_SIZE];
        int maxSubstringLength = 1;
        String longestSubstring = null;
        for(int i = 0; i < STRING_SIZE; i++)
            for(int j = 0; j < STRING_SIZE-1; j++) {
                final int K = j + i;
                if(K >= STRING_SIZE) continue;
                if(str.charAt(j) == str.charAt(K) && (K-j < 3 || table[j+1][K-1])) {
                    table[j][K] = true;
                    if(K-j+1 > maxSubstringLength) {
                        maxSubstringLength = K - j + 1;
                        longestSubstring = str.substring(j, K+1);
                    }
                }
            }
        return longestSubstring;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(new Source().longestPalSubstr(args[0]));
    }
}
