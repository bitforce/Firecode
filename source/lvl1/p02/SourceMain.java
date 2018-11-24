package source.lvl1.p02;

import source.temp.help.MatrixPrinter;

import static source.lvl1.p02.Source.flipItVerticalAxis;

class SourceMain {
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        int e = 2;
        int[][] matrix = new int[arr[0]][arr[1]];
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = arr[e];
                e++;
            }
        MatrixPrinter.print(matrix);
        flipItVerticalAxis(matrix);
        System.out.println();
        MatrixPrinter.print(matrix);
    }
}
