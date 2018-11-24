package source.lvl3.p47;

public class SourceMain {
    public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        System.out.println(new Source().countPaths(M, N));
        System.out.println(new Source().countPaths2(M, N));
        System.out.println(new Source().countPaths3(M, N));
    }
}
