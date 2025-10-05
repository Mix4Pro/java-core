package lesson02.Practice;


import java.util.Scanner;

// Convert USD to UZS
class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int exchange_rate = 12500; // Exchange rate , 1 USD = 12 500 UZS

        System.out.print("Please enter the amount of USD you want to convert to UZS : ");

        int usd = scanner.nextInt();
        scanner.close();

        if (usd >= 0) {
            int uzs = usd * exchange_rate;

            System.out.println("USD : " + usd);
            System.out.println("UZS : " + uzs);
        } else {
            System.out.println("The input amount can't be less than 0");
        }
    }
}