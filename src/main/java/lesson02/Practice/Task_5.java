package lesson02.Practice;


import java.util.Scanner;

// Show the biggest number out of 3
class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter 3 numbers : ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.close();

        if (a > b && a > c) { // a is the biggest
            System.out.println("The biggest number is " + a);
        } else if (b > a && b > c) { // b is the biggest
            System.out.println("The biggest number is " + b);
        } else if (c > a && c > b) { // c is the biggest
            System.out.println("The biggest number is " + c);
        } else { // Numbers are the same
            System.out.println("Numbers are the same");
        }
    }
}