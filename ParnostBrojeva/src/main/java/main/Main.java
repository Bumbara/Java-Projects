package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to check is it even or odd: ");

        int number = scanner.nextInt();

        if (number%2 == 0) {
            System.out.println("The number is even!");
        } else {
            System.out.println("The number is odd!");
        }
    }

}
