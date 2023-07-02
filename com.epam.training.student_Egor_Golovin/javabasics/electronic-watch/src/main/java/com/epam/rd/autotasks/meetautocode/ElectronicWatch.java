package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        System.out.println(String.format(seconds/3600%24 + ":" + "%02d" +  ":" + "%02d", seconds%3600/60, seconds%60));
    }
}
