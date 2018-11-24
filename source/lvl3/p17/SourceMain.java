package source.lvl3.p17;

import source.support.print.MatrixPrinter;

import static source.lvl3.p17.Source.rotateSquareImageCW;
import static source.lvl3.p17.Source.rotateSquareImageCW2;

public class SourceMain {
     public static void main(String[] args) {
        int[] array = new int[args.length];
        for(int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(args[i]);
        int length = Integer.parseInt(args[array.length-1]);
        int[][] matrix = new int[length][length];
        for(int r = 0; r < length; r++)
            for(int c = 0; c < length; c++)
                matrix[r][c] = array[c % matrix[0].length + (r * matrix[0].length)];
        MatrixPrinter.print(matrix);
        rotateSquareImageCW(matrix);
        System.out.println();
        MatrixPrinter.print(matrix);
        System.out.println();
        rotateSquareImageCW2(matrix);
        MatrixPrinter.print(matrix);
    }
}
