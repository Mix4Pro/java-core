package lesson02.BasicTasks;


import java.util.Scanner;


// Sum of number's digits
class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number : ");

        int number = scanner.nextInt();
        scanner.close();

        int sum = 0;
        int divisor = 10;

        if (number > 0) { //Positive number
            while (number > 1) {
                sum += number % divisor; // Gets the remainder of the number as a single digit , then adds it to sum
                number /= divisor; // Cuts the remainder off from the number , so that in the next iteration , next digit will be a remainder
            }
            sum += number % divisor; // Adds one digit that that is left

        } else if (number < 0) { // Negative number
            while (number < -1) {
                sum -= number % divisor; // Since - - = + , it will add a remainder to sum
                number /= divisor;
            }
            sum -= number % divisor; // Since - - = + , it will add a digit to sum
        }

        System.out.println(sum);
    }
}