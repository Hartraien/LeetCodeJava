package ru.hartraien.main.medium.seventynine;

public class WordSearchInGrid
{
    public boolean exist( char[][] board, String word )
    {
        int m = board.length;
        int n = board[0].length;
        for ( int i = 0; i < m; i++ )
        {
            for ( int j = 0; j < n; j++ )
            {
                if ( recSearch( board, word, i, j, 0, new boolean[m][n] ) )
                    return true;
            }
        }
        return false;
    }

    private boolean recSearch( char[][] board, String word, int row, int col, int charPos, boolean[][] visited )
    {
        if ( charPos == word.length() )
            return true;
        if ( row < 0 || col < 0 || row >= board.length || col >= board[0].length )
            return false;
        if ( visited[row][col] || board[row][col] != word.charAt( charPos ) )
            return false;

        visited[row][col] = true;
        boolean result = recSearch( board, word, row - 1, col, charPos + 1, visited )
                || recSearch( board, word, row, col - 1, charPos + 1, visited )
                || recSearch( board, word, row + 1, col, charPos + 1, visited )
                || recSearch( board, word, row, col + 1, charPos + 1, visited );

        visited[row][col] = false;

        return result;
    }
}
