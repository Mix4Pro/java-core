package lesson02.Practice;

import java.util.Random;
import java.util.Scanner;


// Guess the number
class Task_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean found = false;

        System.out.println("Try to guess the number , type in a number from 1 to 10");

        while (!found) {
            System.out.print("Your guess : ");
            int number = scanner.nextInt();
            int randomNumber = random.nextInt(1, 11);

            if (number == randomNumber) {
                System.out.println("Congrats ! You have guessed the number " + randomNumber);
                found = true;
            } else {
                System.out.println("Try again");
            }
        }

        scanner.close();
    }
}