package com.epam.rd.autotasks.arrays;

public class SumOfEvenNumbers {
    public static int sum(int[] array) {
        if (array != null) {
            int sum = 0;
            for (int value : array) {
                if (value % 2 == 0) {
                    sum += value;
                }
            }
            return sum;
        } else return 0;
    }
}
