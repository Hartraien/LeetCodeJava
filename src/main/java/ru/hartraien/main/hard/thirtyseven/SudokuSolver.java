package ru.hartraien.main.hard.thirtyseven;

public class SudokuSolver {
    public static char[][] solver(char[][] board) {
        if (board == null || board.length == 0)
            return null;

        var result = solve(board, 0, 0);
        if (result)
            return board;
        else
            return null;
    }

    private static boolean solve(char[][] board, int i, int j) {
        if (i == 9)
            return true;

        int col_new = (j + 1) % 9;
        int row_new = col_new == 0 ? i + 1 : i;

        if (board[i][j] != '.') {
            return solve(board, row_new, col_new);
        } else {
            for (char num = '1'; num <= '9'; num++) {
                if (!isValid(board, i, j, num))
                    continue;
                board[i][j] = num;

                if (solve(board, row_new, col_new))
                    return true;
                else {
                    board[i][j] = '.';
                }

            }
            return false;
        }
    }

    private static boolean isValid(char[][] board, int i, int j, char num) {


        for (int col = 0; col < board.length; col++) {
            if (col != j && board[i][col] == num)
                return false;
        }
        for (int row = 0; row < board.length; row++) {
            if (row != i && board[row][j] == num)
                return false;
        }

        int rowSquareStart = 3 * (i / 3);
        int colSquareStart = 3 * (j / 3);

        for (int row = rowSquareStart; row < rowSquareStart + 3; row++) {
            for (int col = colSquareStart; col < colSquareStart + 3; col++) {
                if ((row != i || col != j) && board[row][col] == num)
                    return false;
            }
        }

        return true;

    }
}
