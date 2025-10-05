package lesson02.Practice;

import java.util.Scanner;


// Swap values
class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter 2 numbers please : ");


        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        int temp = a;
        a = b;
        b = temp;

        System.out.println(a + " " + b);
    }
}
