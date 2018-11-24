package source.lvl4.p10;

import static source.lvl4.p10.Source.generateIPAddrs;
import static source.lvl4.p10.Source.generateIPAddrs2;
import static source.lvl4.p10.Source.generateIPAddrs3;

public class SourceMain {
     public static void main(String[] args) {
        System.out.println(generateIPAddrs(args[0]));
        System.out.println(generateIPAddrs2(args[0]));
        System.out.println(generateIPAddrs3(args[0]));
    }
}
