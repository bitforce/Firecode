import java.util.*;
class Snake {
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
    private static void fill(int[][] matrix, int[] arr) {
        int e = 2;
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = arr[e];
                e++;
            }
    }
    private static void print(int[][] matrix) {
        for (int[] list : matrix) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int len = args.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = Integer.parseInt(args[i]);
        int[][] matrix = new int[arr[0]][arr[1]];
        fill(matrix, arr);
        print(matrix);
        System.out.println(findSpiral(matrix).toString());
    }
}
