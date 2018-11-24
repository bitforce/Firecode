package source.lvl4.p22;

import static source.lvl4.p22.Source.getCombPerms;
import static source.lvl4.p22.Source.getCombPerms2;
import static source.lvl4.p22.Source.getCombPerms3;

public class SourceMain {
    public static void main(String[] args) {
        System.out.println(getCombPerms(args[0]));
        System.out.println(getCombPerms2(args[0]));
        System.out.println(getCombPerms3(args[0]));
    }
}
