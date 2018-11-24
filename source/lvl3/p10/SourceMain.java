package source.lvl3.p10;

import source.support.print.MatrixPrinter;

import static source.lvl3.p10.Source.findSpiral;

public class SourceMain {
     public static void main(String[] args) {
        final int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        int[][] matrix = new int[arr[0]][arr[1]];
        int e = 2;
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = arr[e];
                e++;
            }
        MatrixPrinter.print(matrix);
        System.out.println(findSpiral(matrix).toString());
    }
}
