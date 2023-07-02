package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        if ( values != null && values.length > 0 ) {
            int maxValue = Integer.MIN_VALUE;
            for (int value: values) {
                if (value > maxValue) { maxValue = value; }
            }
            return OptionalInt.of(maxValue);
        } else return OptionalInt.empty();
    }
}
