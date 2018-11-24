package source.lvl4.p13;

public class SourceMain {
    public static void main(String[] args) {
        final int X = Integer.parseInt(args[0]);
        System.out.println(new Source().swapOddEvenBits(X));
    }
}
