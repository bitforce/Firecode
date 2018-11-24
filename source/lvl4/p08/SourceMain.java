package source.lvl4.p08;

public class SourceMain {
    public static void main(String[] args) {
        final int A = Integer.parseInt(args[0]);
        final int B = Integer.parseInt(args[1]);
        System.out.println(A + " = " + Integer.toBinaryString(A));
        System.out.println(B + " = " + Integer.toBinaryString(B));
        System.out.println(new Source().bitSwapRequired(A, B));
        System.out.println(new Source().bitSwapRequired2(A, B));
        System.out.println(new Source().bitSwapRequired3(A, B));
    }
}
