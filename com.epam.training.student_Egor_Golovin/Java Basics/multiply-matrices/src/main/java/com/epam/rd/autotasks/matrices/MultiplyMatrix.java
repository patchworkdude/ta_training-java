package com.epam.rd.autotasks.matrices;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int rowsM1 = matrix1.length;
        int colsM1 = matrix1[0].length;
        int colsM2 = matrix2[0].length;
        int[][] matrixCopy = new int[rowsM1][colsM2];

        for (int i = 0; i < rowsM1; i++) {
            for (int j = 0; j < colsM2; j++) {
                for (int k = 0; k < colsM1; k++) {
                    matrixCopy[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixCopy;
    }
}
