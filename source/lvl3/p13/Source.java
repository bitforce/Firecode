package source.lvl3.p13;
import source.temp.help.MatrixPrinter;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private ArrayList<String> printPaths(char[][] board) {
        ArrayList<String> list = new ArrayList<>();
        search(0, 0, board, "", list);
        return list;
    }
    public void search(int i, int j, char[][] board, String str, ArrayList<String> list) {
        int rows = board.length;
        int cols = board[0].length;
        if(i >= rows || j >= cols) return;
        String s = str + board[i][j];
        if(i == rows-1 && j == cols-1) {
            list.add(s);
            return;
        }
        if(j + 1 < cols) search(i, j+1, board, s, list);
        if(i + 1 < rows) search(i+1, j, board, s, list);
    }
    /* ********************************************************************* */
    private ArrayList<String> printPaths2(char[][] board){
        ArrayList<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        search2(0,0,board,sb,out);
        return out;
    }

    public void search2(int i, int j, char[][] board, StringBuilder sb, ArrayList<String> out){
        int rows = board.length;
        int cols = board[0].length;
        if(i > rows-1 || j > cols-1) return;
        
        sb.append(board[i][j]);
        if(i == rows-1 && j == cols-1){
            out.add(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        search2(i+1,j,board,sb,out);
        search2(i,j+1,board,sb,out);
        sb.deleteCharAt(sb.length()-1);
    }
    /* ********************************************************************* */
    public ArrayList<String> printPaths3(char[][] board){
        ArrayList<String> result = new ArrayList<String>();
        if(board.length!=0 && board[0].length!=0) search3(result, "", 0, 0, board);
        return result;
    }

    private void search3(ArrayList<String> result, String str, int i, int j, char[][] board) {
        str += board[i][j];
        if(i==board.length-1 && j==board[0].length-1) result.add(str);
        else {
            if(i<board.length-1) search3(result, str, i+1, j, board);
            if(j<board[0].length-1) search3(result, str, i, j+1, board);
        }
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        String s = "";
        for (int i = 2; i < args.length; i++) s += args[i];
        char[][] matrix = new char[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++)
                matrix[r][c] = s.toCharArray()[(c % matrix[0].length) + (r * matrix[0].length)];
        MatrixPrinter.print(matrix);
        System.out.println(new Source().printPaths(matrix).toString());
        System.out.println(new Source().printPaths2(matrix).toString());
        System.out.println(new Source().printPaths3(matrix).toString());
    }
}
