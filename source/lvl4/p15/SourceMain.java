package source.lvl4.p15;

import source.support.print.MatrixPrinter;

import static source.lvl4.p15.Source.rotate;
import static source.lvl4.p15.Source.rotate2;

public class SourceMain {
    public static void main(String[] args) {
        final int L = args.length;
        if(Math.sqrt(L) != Math.floor(Math.sqrt(L))) return;
        int s = (int) Math.sqrt(L);
        int[][] matrix = new int[s][s];
        int[] arr = new int[L];
        for (int i = 0; i < L; i++)
            arr[i] = Integer.parseInt(args[i]);
        int e = 0;
        for(int i = 0; i < s; i++)
            for(int j = 0; j < s; j++) {
                matrix[i][j] = arr[e++];
            }
        MatrixPrinter.print(matrix);
        System.out.println();
        MatrixPrinter.print(rotate(matrix));
        System.out.println();
        MatrixPrinter.print(rotate2(matrix));
    }
}
