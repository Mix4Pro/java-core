package lesson02.BasicTasks;

import java.util.Scanner;

// Display all the prime numbers up to N
class Task_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number : ");
        int number = scanner.nextInt();
        scanner.close();

        if (number > 0) {
            for (int i = 1; i < number; i++) {
                if (i % 2 != 0 || i == 2) {
                    int counter = 0;
                    for (int j = 1; j < i; j++) {
                        if (i % j == 0) {
                            counter++;
                        }
                    }
                    if (counter == 1) {
                        System.out.print(i + " ");
                    }
                }
            }
        } else if (number < 0) {
            for (int i = -1; i > number; i--) {
                if (i % 2 != 0 || i == -2) {
                    int counter = 0;
                    for (int j = -1; j > i; j--) {
                        if (i % j == 0) {
                            counter++;
                        }
                    }

                    if (counter == 1) {
                        System.out.print(i + " ");
                    }
                }
            }
        }
    }
}
