package lesson06;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airplane aircraft = new Airplane();

        int choice = 0;

        while (choice != 5) {
            System.out.println("Choose an option : ");
            System.out.println("1) Show all the flights");
            System.out.println("2) Show a certain seat information");
            System.out.println("3) Book a seat");
            System.out.println("4) Unbook a seat");
            System.out.println("5) Exit");

            System.out.print("Your option : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    aircraft.showAllPlaces();
                    break;
                case 2:
                    System.out.print("Please enter a seat id to display its information : ");
                    String placeId_info_show = scanner.nextLine();

                    aircraft.showPlaceInfo(placeId_info_show);
                    break;
                case 3:
                    System.out.print("Please enter the seat id you want to book : ");
                    String placeId_book = scanner.nextLine();

                    System.out.print("Please enter your name : ");
                    String name = scanner.nextLine();

                    aircraft.bookAPlace(placeId_book, name);
                    break;
                case 4:
                    System.out.print("Please enter a seat id you want to unbook : ");
                    String placeId_unbook = scanner.nextLine();

                    aircraft.unbookAPlace(placeId_unbook);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Incorrect option , try again");
                    System.out.println();
            }
        }
    }
}
