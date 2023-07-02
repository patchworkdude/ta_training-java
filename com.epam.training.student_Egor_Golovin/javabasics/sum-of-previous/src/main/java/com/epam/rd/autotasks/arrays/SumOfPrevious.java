package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class SumOfPrevious {
    public static boolean[] getSumCheckArray(int[] array) {
        boolean[] result = new boolean[array.length];
        Arrays.fill(result, false);

        for (int i = 2; i < array.length; i++) {
            if (array[i] == array[i - 1] + array[i - 2]) {
                result[i] = true;
            }
        } return result;
    }
}
