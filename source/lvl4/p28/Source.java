package source.lvl4.p28;
import source.support.print.MatrixPrinter;

class Source {
    /* ********************************************************************* */
    private static boolean boggleSearch(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(boggleSearch(board, word, i, j))
                    return true;
        return false;
    }
    private static boolean boggleSearch(char[][] board, String word, int row, int col) {
        if(word.equals("")) return true;
        if(row < 0 || row >= board.length || 
           col < 0 || col >= board[0].length ||
           board[row][col] != word.charAt(0)) return false;
        char c = board[row][col];
        board[row][col] = '*';
        String remainder = word.substring(1, word.length());
        boolean result = boggleSearch(board, remainder, row-1, col) ||
                         boggleSearch(board, remainder, row+1, col) ||
                         boggleSearch(board, remainder, row, col-1) ||
                         boggleSearch(board, remainder, row, col+1);
        board[row][col] = c;
        return result;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final int M = Integer.parseInt(args[0]);
        final int N = Integer.parseInt(args[1]);
        char[][] board = new char[M][N];
        int e = 3;
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = args[e++].charAt(0);
        MatrixPrinter.print(board);
        System.out.println(boggleSearch(board, args[2]));
    }
}
