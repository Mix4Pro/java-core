package lesson02.BasicTasks;

import java.util.Scanner;


// Display the number in opposite order
class Task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number : ");
        int number = scanner.nextInt();
        scanner.close();
        int divisor = 10;

        if (number >= 0) {
            while (number > 1) {
                System.out.print(number % divisor);
                number /= divisor;
            }
            System.out.print(number);
        } else {
            number *= -1;
            while (number > 1) {
                System.out.print(number % divisor);
                number /= divisor;
            }
            System.out.print(number + "-");
        }
    }
}
