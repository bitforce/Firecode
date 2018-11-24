package source.lvl3.p13;

import source.support.print.MatrixPrinter;

public class SourceMain {
     public static void main(String[] args) {
        final StringBuilder s = new StringBuilder();
        for (int i = 2; i < args.length; i++) s.append(args[i]);
        char[][] matrix = new char[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++)
                matrix[r][c] = s.toString().toCharArray()[(c % matrix[0].length) + (r * matrix[0].length)];
        MatrixPrinter.print(matrix);
        System.out.println(new Source().printPaths(matrix).toString());
        System.out.println(new Source().printPaths2(matrix).toString());
        System.out.println(new Source().printPaths3(matrix).toString());
    }
}
