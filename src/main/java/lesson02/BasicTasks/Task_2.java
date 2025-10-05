package lesson02.BasicTasks;

import java.util.Scanner;

// Display sum of all numbers up to N
class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Please enter the N value (number) : ");
        int N = scanner.nextInt();
        scanner.close();
        int sum = 0;


        if (N > 0) { // Positive N
            for (int i = 0; i <= N; i++) {
                sum += i;
            }
            System.out.println("The sum of numbers up to N : " + sum);
        } else if (N < 0) { // Negative N
            System.out.println("N can't be negative");
        } else { // N equals to 0
            System.out.println("The sum of numbers up to N : " + sum);
        }
    }
}