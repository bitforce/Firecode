package source.temp.help;
public class MatrixPrinter {
    public static <T> void print(T[][] matrix) {
        for(T a[] : matrix) {
            for(T e : a)
                System.out.print(e + " "); 
            System.out.println(); 
        }
    }
    public static void print(int[][] matrix) {
        for(int[] a : matrix) {
            for(int i : a)
                System.out.print(i + " ");
           System.out.println();  
        }
    }
}
