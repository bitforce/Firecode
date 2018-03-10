package source.lvl4.p16;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
        int[][] matrix = new int[input.size()][input.size()];
        for(int i = 0; i < input.size(); i++) Arrays.fill(matrix[i], 0);
        assist(input, 0, 0, matrix);
        return matrix[0][0];
    }
    private static int assist(ArrayList<ArrayList<Integer>> input, int level,
                              int index, int[][] matrix) {
        if(level + 1 == input.size()) {
            matrix[level][index] = input.get(level).get(index);
            return matrix[level][index];
        }
        int left = matrix[level+1][index] == 0
            ? assist(input, level + 1, index, matrix) 
            : matrix[level+1][index];
        int right = matrix[level+1][index+1] == 0
            ? assist(input, level+1, index+1, matrix)
            : matrix[level+1][index+1]; 
        matrix[level][index] = input.get(level).get(index) 
            + Math.min(left, right);
        return matrix[level][index];
    }
    /* ********************************************************************* */
    private static int minTriangleDepth2(ArrayList<ArrayList<Integer>> input) {
        int[] total = new int[input.size()];
        int l = input.size() - 1;
        for (int i = 0; i < input.get(l).size(); i++)
            total[i] = input.get(l).get(i);
        for (int i = input.size()-2; i >= 0; i--)
            for (int j = 0; j < input.get(i+1).size()-1; j++)
                total[j] = input.get(i).get(j) + Math.min(total[j], total[j+1]);
        return total[0];
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        ArrayList<Integer> blist = new ArrayList<>();
        int k = 0;
        int m = 1;
        for(int i = 0; i < args.length; i++) {
            for(int j = i; j < i+m; j++) {
                blist.add(Integer.parseInt(args[j]));
                k++;
            }
            alist.add(new ArrayList<Integer>(blist));
            blist.clear();
            i = k-1;
            m++;
        }
        System.out.println(alist.toString());
        System.out.println(minTriangleDepth(alist));
        System.out.println(minTriangleDepth2(alist));
    }
}
