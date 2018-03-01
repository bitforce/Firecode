package source.lvl4.p08;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int bitSwapRequired(int a, int b) {
        String ax;
        String bx;
        if(Integer.toBinaryString(a).length() !=
           Integer.toBinaryString(b).length()) {
            ax = Integer.toBinaryString(a).toString().length() >
                 Integer.toBinaryString(b).toString().length() ?
                 Integer.toBinaryString(a)                     :
                 Integer.toBinaryString(b)                     ;
            bx = ax.equals(Integer.toBinaryString(a))          ?
                 Integer.toBinaryString(b)                     :
                 Integer.toBinaryString(a)                     ; 
            for(int i = ax.length()-1; i > bx.length()-1; i--)
                if(ax.charAt(i) == '0')
                    ax = ax.substring(0, ax.length()-1);
                else break;
        } else {
            ax = Integer.toBinaryString(a);
            bx = Integer.toBinaryString(b);
        }
        int count = 0;
        for(int i = 0; i < ax.length(); i++)
            if(ax.charAt(i) != bx.charAt(i)) count++;
        return count;
    }
    /* ********************************************************************* */
    private int bitSwapRequired2(int a, int b) {
        int count = 0;
        for(int c=a^b; c!=0; c = c & (c-1)) count++;
        return count;
    }
    /* ********************************************************************* */
    private int bitSwapRequired3(int a, int b) {
        return Math.abs(Integer.bitCount(a^b));
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(a + " = " + Integer.toBinaryString(a));
        System.out.println(b + " = " + Integer.toBinaryString(b));
        System.out.println(new Source().bitSwapRequired(a, b));
        System.out.println(new Source().bitSwapRequired2(a, b));
        System.out.println(new Source().bitSwapRequired3(a, b));
    }
}
