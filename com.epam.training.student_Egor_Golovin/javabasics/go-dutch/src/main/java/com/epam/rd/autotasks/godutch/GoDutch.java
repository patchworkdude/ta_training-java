package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int billAmount = scanner.nextInt();
        int friendsNum = scanner.nextInt();

        if (billAmount < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (friendsNum <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            System.out.println((int) (billAmount*1.1/friendsNum));
        }
    }
}
