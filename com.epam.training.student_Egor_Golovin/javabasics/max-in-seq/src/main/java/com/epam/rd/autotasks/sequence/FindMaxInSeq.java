package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner scanner = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int num = max;

        while (num != 0) {
            if (num > max) {
                max = num;
            }
            num = scanner.nextInt();
        }
        return max;
    }
}
