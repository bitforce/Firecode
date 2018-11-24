package source.lvl2.p08;

import static source.lvl2.p08.Source.reverseInt;
import static source.lvl2.p08.Source.reverseInt2;

public class SourceMain {
     public static void main(String[] args) {
        System.out.println(reverseInt(Integer.parseInt(args[0])));
        System.out.println(reverseInt2(Integer.parseInt(args[0])));
    }
}
