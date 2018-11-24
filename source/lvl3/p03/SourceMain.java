package source.lvl3.p03;

import static source.lvl3.p03.Source.isHappyNumber;
import static source.lvl3.p03.Source.isHappyNumber2;
import static source.lvl3.p03.Source.isHappyNumber3;

public class SourceMain {
     public static void main(String[] args) {
        System.out.println(isHappyNumber(Integer.parseInt(args[0])));
        System.out.println(isHappyNumber2(Integer.parseInt(args[0])));
        System.out.println(isHappyNumber3(Integer.parseInt(args[0])));
    }
}
