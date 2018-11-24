package source.lvl2.p14;

import static source.lvl2.p14.Source.compressString;
import static source.lvl2.p14.Source.compressString2;
import static source.lvl2.p14.Source.compressString3;

public class SourceMain {
     public static void main(String[] args) {
        System.out.println(compressString(args[0]));
        System.out.println(compressString2(args[0]));
        System.out.println(compressString3(args[0]));
    }
}
