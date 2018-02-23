package source.lvl4.p06;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int editDistance(String a, String b) {
        int edit[][] = new int[a.length()+1][b.length()+1];
        for(int i = 0; i < a.length(); i++) edit[i][0] = i;
        for(int j = 0; j < b.length(); j++) edit[0][j] = j;
        for(int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            for(int j = 0; j < b.length(); j++) {
                char cb = b.charAt(j);
                if(ca == cb) edit[i+1][j+1] = edit[i][j];
                else {
                    int replace = edit[i][j] + 1;
                    int insert = edit[i][j+1] + 1;
                    int delete = edit[i+1][j] + 1;
                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    edit[i+1][j+1] = min;
                }
            }
        }
        return edit[a.length()][b.length()];
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(new Source().editDistance(args[0], args[1]));
    }
}
