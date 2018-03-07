package source.lvl4.p13;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private int swapOddEvenBits(int x) {
        return (x & 0xAAAAA) >>> 1 | (x & 0x55555) << 1;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println(new Source().swapOddEvenBits(x));
    }
}
