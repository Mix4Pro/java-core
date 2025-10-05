package lesson02.BasicTasks;

import java.util.Scanner;

// Factorial implementation with a loop
class Task_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Please enter a number : ");
        int number = scanner.nextInt();
        scanner.close();
        int factorial = 1;

        if (number >= 0) {
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("Factorial is : " + factorial);
        } else {
            System.out.println("Can't calculate factorial of a negative number");
        }
    }
}