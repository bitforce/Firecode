package source.lvl3.p13;

import java.util.ArrayList;

class Source {
    ArrayList<String> printPaths(final char[][] board) {
        ArrayList<String> list = new ArrayList<>();
        search(0, 0, board, "", list);
        return list;
    }
    public void search(final int i, final int j, final char[][] board, String str, final ArrayList<String> list) {
        int rows = board.length;
        int cols = board[0].length;
        if(i >= rows || j >= cols) return;
        final String s = str + board[i][j];
        if(i == rows-1 && j == cols-1) {
            list.add(s);
            return;
        }
        if(j + 1 < cols) search(i, j+1, board, s, list);
        if(i + 1 < rows) search(i+1, j, board, s, list);
    }
    /* ********************************************************************* */
    ArrayList<String> printPaths2(final char[][] board){
        final ArrayList<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        search2(0,0,board,sb,out);
        return out;
    }
    private void search2(final int i, final int j, final char[][] board, final StringBuilder sb, final ArrayList<String> out) {
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
    ArrayList<String> printPaths3(char[][] board){
        ArrayList<String> result = new ArrayList<String>();
        if(board.length!=0 && board[0].length!=0) search3(result, "", 0, 0, board);
        return result;
    }
    private void search3(final ArrayList<String> result, String str, final int i, final int j, final char[][] board) {
        str += board[i][j];
        if(i==board.length-1 && j==board[0].length-1) result.add(str);
        else {
            if(i<board.length-1) search3(result, str, i+1, j, board);
            if(j<board[0].length-1) search3(result, str, i, j+1, board);
        }
    }
}
