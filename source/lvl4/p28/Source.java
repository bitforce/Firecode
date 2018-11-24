package source.lvl4.p28;

class Source {
    static boolean boggleSearch(final char[][] board, final String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(boggleSearch(board, word, i, j))
                    return true;
        return false;
    }
    private static boolean boggleSearch(final char[][] board, final String word, final int ROW, final int COL) {
        if(word.equals("")) return true;
        if(ROW < 0 || ROW >= board.length ||
           COL < 0 || COL >= board[0].length ||
           board[ROW][COL] != word.charAt(0)) return false;
        char c = board[ROW][COL];
        board[ROW][COL] = '*';
        String remainder = word.substring(1);
        boolean result = boggleSearch(board, remainder, ROW-1, COL) ||
                         boggleSearch(board, remainder, ROW+1, COL) ||
                         boggleSearch(board, remainder, ROW, COL-1) ||
                         boggleSearch(board, remainder, ROW, COL+1);
        board[ROW][COL] = c;
        return result;
    }
}
