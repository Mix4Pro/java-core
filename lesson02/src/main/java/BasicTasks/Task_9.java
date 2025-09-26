package BasicTasks;


import java.util.Scanner;

class Task_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number : ");
        int number = scanner.nextInt();
        scanner.close();
        int sum = 0;

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
                        sum += i;
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
                        sum += i;
                    }
                }
            }
        }

        System.out.println("The sum of prime numbers up to " + number + " is " + sum);
    }
}
