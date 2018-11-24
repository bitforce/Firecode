package source.lvl1.p11;

import static source.lvl1.p11.Source.areAllCharactersUnique;
import static source.lvl1.p11.Source.areAllCharactersUnique2;

public class SourceMain {
    public static void main(String[] args) {
        System.out.println(areAllCharactersUnique(args[0]));
        System.out.println(areAllCharactersUnique2(args[0]));
    }
}
