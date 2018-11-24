package source.lvl2.p16;

import static source.lvl2.p16.Source.isIsomorphic;
import static source.lvl2.p16.Source.isIsomorphic2;

public class SourceMain {
     public static void main(String[] args) {
        System.out.println(isIsomorphic(args[0], args[1]));
        System.out.println(isIsomorphic2(args[0], args[1]));
    }
}
