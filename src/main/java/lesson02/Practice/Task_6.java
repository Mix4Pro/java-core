package lesson02.Practice;


import java.util.Scanner;


// Calculator
class Task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter 2 numbers : ");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        double res = 0;
        int error = 0;

        System.out.print("Please enter the option ( + , - , * , / ) ");
        String option = scanner.next();
        scanner.close();

        switch (option) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                if (b == 0) {
                    error = 1;
                    break;
                }
                res = (double) a / (double) b;
                break;
            default:
                error = 2;
                break;
        }

        if (error == 0) {
            System.out.println("Result : " + res);
        } else if (error == 1) {
            System.out.println("Can't divide by 0");
        } else {
            System.out.println("You have chose an incorrect option");
        }
    }
}