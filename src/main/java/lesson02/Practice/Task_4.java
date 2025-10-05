package lesson02.Practice;

import java.util.Scanner;


// Odd or even number check
class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the number you want to check : ");
        int number = scanner.nextInt();
        scanner.close();

        if (number == 0) { // Zero is zero , it's neither even nor odd
            System.out.println("It's 0");
        } else if (number % 2 == 0) { // Even
            System.out.println("Even");
        } else { // Odd
            System.out.println("Odd");
        }
    }
}