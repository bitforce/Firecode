package source.lvl5.p01;

class Source {
    String longestPalSubstr(final String str) {
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
    String longestPalSubstr2(final String str) {
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
    String longestPalSubstr3(final String str) {
        final int N = str.length();
        String longest = str.substring(0, 1);

        for (int i = 0; i < N - 1; i++) {
            String s1 = expandAroundCentre(str, i, i);
            if (s1.length() > longest.length()) {
                longest = s1;
            }

            String s2 = expandAroundCentre(str, i, i + 1);
            if (s2.length() > longest.length()) {
                longest = s2;
            }
        }
        return longest;
    }

    private String expandAroundCentre(final String str, int l, int r) {
        final int N = str.length();
        while (l >= 0 && r < N && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return str.substring(l + 1, r);
    }
}
