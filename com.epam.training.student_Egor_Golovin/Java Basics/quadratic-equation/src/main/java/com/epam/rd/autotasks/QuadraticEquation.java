package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double D = Math.sqrt(Math.pow(b,2) - 4 * a * c);

        if (D > 0) {
            double x1 = (-b + D) / (2 * a);
            double x2 = (-b - D) / (2 * a);
            System.out.println(x1 + " " + x2);
        } else if (D == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        } else {
            System.out.println("no roots");
        }
    }
}