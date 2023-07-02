package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {
    public static int[] removeLocalMaxima(int[] array) {
        int[] result = new int[array.length];
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if ((i > 0 && array[i] <= array[i - 1])
                    || (i != array.length - 1 && array[i] <= array[i + 1])){
                result[j++] = array[i];
            }
        }
        return Arrays.copyOf(result, j);
    }
}
