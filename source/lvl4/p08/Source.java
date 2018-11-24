package source.lvl4.p08;

class Source {
    int bitSwapRequired(final int a, final int b) {
        String ax;
        String bx;
        if(Integer.toBinaryString(a).length() !=
           Integer.toBinaryString(b).length()) {
            ax = Integer.toBinaryString(a).length() >
                 Integer.toBinaryString(b).length() ?
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
    int bitSwapRequired2(int a, int b) {
        int count = 0;
        for(int c=a^b; c!=0; c = c & (c-1)) count++;
        return count;
    }
    /* ********************************************************************* */
    int bitSwapRequired3(int a, int b) {
        return Math.abs(Integer.bitCount(a^b));
    }
}
