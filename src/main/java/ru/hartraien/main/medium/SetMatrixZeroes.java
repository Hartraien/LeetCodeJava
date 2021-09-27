package ru.hartraien.main.medium;

import java.util.BitSet;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        final BitSet rowsMask = new BitSet(200);
        final BitSet columnsMask = new BitSet(200);

        final int rowcount = matrix.length;
        final int colcount = matrix[0].length;

        for (int i = 0; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                if (matrix[i][j] == 0) {
                    rowsMask.set(i);
                    columnsMask.set(j);
                }
            }
        }

        int minMeasure = Math.min(rowcount, colcount);
        for (int i = 0; i < minMeasure; i++) {
            if (rowsMask.get(i)) {
                for (int j = 0; j < colcount; j++)
                    matrix[i][j] = 0;
            }
            if (columnsMask.get(i)) {
                for (int j = 0; j < rowcount; j++)
                    matrix[j][i] = 0;
            }
        }

        for (int i = minMeasure; i < rowcount; i++) {
            if (rowsMask.get(i)) {
                for (int j = 0; j < colcount; j++)
                    matrix[i][j] = 0;
            }
        }

        for (int i = minMeasure; i < colcount; i++) {
            if (columnsMask.get(i)) {
                for (int j = 0; j < rowcount; j++)
                    matrix[j][i] = 0;
            }
        }

    }
}
