package source.lvl4.p16;

import java.util.ArrayList;
import java.util.Arrays;

class Source {
    static int minTriangleDepth(final ArrayList<ArrayList<Integer>> input) {
        final int[][] matrix = new int[input.size()][input.size()];
        for(int i = 0; i < input.size(); i++) Arrays.fill(matrix[i], 0);
        assist(input, 0, 0, matrix);
        return matrix[0][0];
    }
    private static int assist(
            final ArrayList<ArrayList<Integer>> input,
            final int level,
            final int index,
            final int[][] matrix) {
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
    static int minTriangleDepth2(final ArrayList<ArrayList<Integer>> input) {
        final int[] total = new int[input.size()];
        final int L = input.size() - 1;
        for (int i = 0; i < input.get(L).size(); i++)
            total[i] = input.get(L).get(i);
        for (int i = input.size()-2; i >= 0; i--)
            for (int j = 0; j < input.get(i+1).size()-1; j++)
                total[j] = input.get(i).get(j) + Math.min(total[j], total[j+1]);
        return total[0];
    }
}
