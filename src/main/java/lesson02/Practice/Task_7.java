package lesson02.Practice;


import java.util.Scanner;


// Arithmetic mean
class Task_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter an array of numbers : ");
        String line = scanner.nextLine(); // Get the whole line

        scanner.close();

        int error = 0;

        String[] tokens = line.split(" ");
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            try {
                numbers[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) { // If non-number value is entered
                System.out.println("Array should consist of numbers only");
                error = 1;
                return;
            }
        }

        if (error == 0) {
            double sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }

            sum /= numbers.length;

            System.out.println("Arithmetic mean : " + sum);
        }
    }
}
