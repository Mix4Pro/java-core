package lesson02.BasicTasks;


import java.util.Scanner;


// Display sum of all even numbers up to N
class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Please enter the N value (number) : ");
        int N = scanner.nextInt();
        scanner.close();
        int sum = 0;

        if (N > 0) { // Positive N
            for (int i = 1; i <= N; i++) {
                if (i % 2 == 0) {
                    sum += i;
                    i++; // Making i to increment by 2 after there is an even number found
                }
            }

            System.out.println("The sum of even numbers up to N : " + sum);
        } else if (N < 0) { // Negative N
            System.out.println("N can't be negative");
        } else { // N equals to 0
            System.out.println("The sum of even numbers up to N : " + sum);
        }
    }
}