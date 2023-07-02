package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] spiral = new int[rows][columns];
        int i = 1;
        int c1 = 0;
        int c2 = columns-1;
        int r1 = 0;
        int r2 = rows-1;

        while (i <= rows*columns) {
            for (int j = c1; j <= c2; i++, j++) {
                spiral[r1][j] = i;
            }

            for (int j = r1; j < r2; i++, j++) {
                spiral[j+1][c2] = i;
            }

            if (r1 >= r2) {
                break;
            }
            for (int j = c2; j > c1; i++, j--) {
                spiral[r2][j-1] = i;
            }

            if (c1 >= c2) {
                break;
            }
            for (int j = r2; j > r1+1; i++, j--) {
                spiral[j-1][c1] = i;
            }
            c1++;
            c2--;
            r1++;
            r2--;
        }
        return spiral;
    }
}
