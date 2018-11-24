package source.lvl4.p27;

import static source.lvl4.p27.Source.getPermutations;
import static source.lvl4.p27.Source.getPermutations2;
import static source.lvl4.p27.Source.getPermutations3;

public class SourceMain {
    public static void main(String[] args) {
        System.out.println(getPermutations(args[0]));
        System.out.println(getPermutations2(args[0]));
        System.out.println(getPermutations3(args[0]));
    }
}
