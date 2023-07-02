package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfPeople = scan.nextInt();
        int numOfSlices = scan.nextInt();

        int numOfPizzas = 1;
        while ((numOfSlices * numOfPizzas) % numOfPeople != 0) {
            numOfPizzas++;
        }

        System.out.println(numOfPizzas);
    }
}
