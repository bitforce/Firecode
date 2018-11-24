package source.lvl3.p10;
import source.support.print.MatrixPrinter;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static ArrayList<Integer> findSpiral(int[][] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int clen = arr[0].length;
        int rlen = arr.length;
        int ridx = 0;
        int cidx = 0;
        int i;
        while(ridx < rlen && cidx < clen) {
            for(i = cidx; i < clen; ++i)
                list.add(arr[ridx][i]);
            ridx++;
            for(i = ridx; i < rlen; ++i)
                list.add(arr[i][clen-1]);
            clen--;
            if(ridx < rlen) {
                for(i = clen-1; i >= cidx; --i)
                    list.add(arr[rlen-1][i]);
                rlen--;
            }
            if(cidx < clen) {
                for(i = rlen-1; i >= ridx; --i)
                    list.add(arr[i][cidx]);
                cidx++;                
            } 
        }
        return list;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        int[] arr = new int[args.length];
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
