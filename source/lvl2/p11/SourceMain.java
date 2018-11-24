package source.lvl2.p11;

import static source.lvl2.p11.Source.isIntPalindrome;
import static source.lvl2.p11.Source.isIntPalindrome2;

public class SourceMain {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        System.out.println(isIntPalindrome(N));
        System.out.println(isIntPalindrome2(N));
    }
}
