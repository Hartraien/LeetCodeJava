package ru.hartraien.main.hard.fiftyone;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        }

        dfs(board, 0, result);
        return result;

    }

    private static void dfs(char[][] board, int colindex, List<List<String>> res) {
        if (colindex == board.length) {
            res.add(construct(board));
            return;
        }


        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, colindex)) {
                board[row][colindex] = 'Q';
                dfs(board, colindex + 1, res);
                board[row][colindex] = '.';
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>(board.length);
        for (char[] chars : board) {
            res.add(new String(chars));
        }
        return res;
    }

    private static boolean validate(char[][] board, int row, int colindex) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q' && (i == row || i + j == row + colindex || row + j == colindex + i)) {
                    return false;
                }
            }
        }
        return true;
    }


}
