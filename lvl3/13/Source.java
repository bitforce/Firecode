import java.util.*;

class Source {
    /* ********************************************************************* */
    private ArrayList<String> printPaths(char[][] board) {return null;}
    /* ********************************************************************* */
    public static void main(String[] args) {
        String s = "";
        for (int i = 2; i < args.length; i++) s += args[i];
        char[][] matrix = new char[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++)
                matrix[r][c] = s.toCharArray()[(c % matrix[0].length) + (r * matrix[0].length)];
        print(matrix);
        System.out.println(printPaths(matrix).toString());
    }

    private static void print(char[][] matrix) {
        for (char[] list : matrix) {
            for (char i : list)
                System.out.print(i + " ");
            System.out.println("");
        }
        System.out.println();
    }
}
