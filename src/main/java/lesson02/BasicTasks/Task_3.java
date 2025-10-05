package lesson02.BasicTasks;

import java.util.Scanner;

// Display multiplication product of all numbers up to N
class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Please enter the N value (number) : ");
        int N = scanner.nextInt();
        scanner.close();
        int product = 1;

        if (N > 0 && N != 1) { // Positive N
            for (int i = 1; i <= N; i++) {
                product *= i;
            }
            System.out.println("The multiplication product of numbers up to N : " + product);
        } else if (N < 0) { // Negative N
            System.out.println("N can't be negative");
        } else { // N equals to 0 or 1
            System.out.println("The multiplication product of numbers up to N : 0 ");
        }
    }
}