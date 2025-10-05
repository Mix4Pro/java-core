package lesson02.Practice;


import java.util.Scanner;

// Search for a number in an array
class Task_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Please enter an array of numbers : ");
        String line = scanner.nextLine();

        System.out.print("Please enter a number you want to look for in the array : ");
        int number_to_look_for = scanner.nextInt();

        scanner.close();

        boolean error = false;
        boolean found = false;


        String[] tokens = line.split(" ");
        int[] number_array = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            try {
                number_array[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                System.out.println("Array should consist of numbers only");
                error = true;
                return;
            }
        }

        if (!error) {
            for (int i = 0; i < number_array.length; i++) {
                if (number_to_look_for == number_array[i]) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("This number is in the array");
            } else {
                System.out.println("There is no number like this in the array");
            }
        }
    }
}