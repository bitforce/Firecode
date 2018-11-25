package source.lvl5.p03;

import static source.lvl5.p03.Source.generatePascalTriangle;
import static source.lvl5.p03.Source.generatePascalTriangle2;

public class SourceMain {
     public static void main(String[] args) {
        final int ROWS = Integer.parseInt(args[0]);
        System.out.println(generatePascalTriangle(ROWS));
        System.out.println(generatePascalTriangle2(ROWS));
    }
}
