package com.epam.rd.autotasks.max;

import java.util.Arrays;

public class MaxMethod {
    public static int max(int[] values) {
        Arrays.sort(values);
        return values[values.length-1];
    }
}
