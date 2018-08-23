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
    private String longestPalSubstr2(String str){
        int length = str.length();
        int max = 0;
        int start = -1;
        for (int startRow = 0; startRow < length; startRow += 1) {
            int current = 0;
            int currentStart = 0;
            for (int col = 0; col <= startRow; col += 1) {
                if (str.charAt(col) == str.charAt(startRow - col))
                    current += 1;
                 else {
                    current = 0;
                    currentStart = col + 1;
                } 
                if (current > max) {
                    max = current;
                    start = currentStart;
                }
            }
        }  
        for (int startRow = 1; startRow < length; startRow += 1) {
            int current = 0;
            int currentStart = startRow;
            for (int col = length - 1; col >= startRow; col -= 1) {
                if (str.charAt(col) == str.charAt(startRow + length - 1 - col))
                    current += 1;
                else {
                    current = 0;
                    currentStart = startRow + length - col;
                } 
                if (current > max) {
                    max = current;
                    start = currentStart;
                }
            }
        } 
        return str.substring(start, start + max);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(new Source().longestPalSubstr(args[0]));
        System.out.println(new Source().longestPalSubstr2(args[0]));
    }
}
