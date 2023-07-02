package com.epam.rd.autotasks.meetstrangers;

import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int strangersNum = scanner.nextInt();

        if (strangersNum > 0) {
            String[] nameArr = new String[strangersNum];
            for (int i = 0; i < nameArr.length; i++) {
                Scanner nameScanner = new Scanner(System.in);
                nameArr[i] = nameScanner.nextLine();
            }
            for (String s : nameArr) {
                System.out.println("Hello, " + s);
            }
        } else if (strangersNum == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else {
            System.out.println("Seriously? Why so negative?");
        }
    }
}
