/**
 * Find the Transpose of a Square Matrix.
 * You are given a square 2D image matrix where each integer represents a 
 * pixel. Write a method transposeMatrix to transform the matrix into 
 * its Transpose - in-place.
 */
class TransposeMatrix {
    private static void tranposeMatrix(int[][] matrix) {
        int tmp1, tmp2;
        int len = matrix.length;
        for(int i = 0; i < len; i++) 
            for(int j = i; j < len; j++) {
                tmp1 = matrix[i][j];
                tmp2 = matrix[j][i];
                matrix[i][j] = tmp2;
                matrix[j][i] = tmp1;
            }
    }

    // BEST SOLUTION
    private static void tranposeMatrix(int[][] matrix) {
        int temp;
        int len = matrix.length;
        for(int r = 0; r < len; r++)
            for(int c = r+1; c < len; c++) {
                temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] list : matrix) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println("");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int len = args.length;

        int[] arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = Integer.parseInt(args[i]);

        int e = 2;
        int[][] matrix = new int[arr[0]][arr[1]];
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = arr[e];
                e++;
            }
        printMatrix(matrix);
        tranposeMatrix(matrix);
        printMatrix(matrix);
    }
}
