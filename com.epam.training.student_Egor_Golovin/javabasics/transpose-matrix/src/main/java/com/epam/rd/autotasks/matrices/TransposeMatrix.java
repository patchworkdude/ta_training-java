package com.epam.rd.autotasks.matrices;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] matrixCopy = new int[column][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrixCopy[j][i] = matrix[i][j];
            }
        }
        return matrixCopy;
    }
}
