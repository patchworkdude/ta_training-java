package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();

        if (a > b || a >= h) {
            int currentPos = 0;
            int day = 1;

            while (currentPos < h) {
                currentPos += a;
                if (currentPos >= h) {
                    break;
                }
                currentPos -= b;
                day++;
            }
            System.out.println(day);
        } else {
            System.out.println("Impossible");
        }
    }
}
