package lesson03.Practice;

import java.util.Scanner;
import java.util.ArrayList;

class OnlineStore {
    private static int codeGenerator = 0;
    private final int code;
    private final String name;
    private double price;
    private int count;

    private static ArrayList<OnlineStore> itemsCollection = new ArrayList<>();

    OnlineStore() {
        this.code = 0;
        this.name = "";
        this.price = 0;
        this.count = 0;
    }

    OnlineStore(String name, double price, int count) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price should be greater than 0");
        } else if (count < 0) {
            throw new IllegalArgumentException("Quantity of available products can't be less than 0");
        } else {
            ++codeGenerator;
            this.code = codeGenerator;
            this.name = name;
            this.price = price;
            this.count = count;
        }
    }

    public void addProduct() {
        boolean found = false;
        for (OnlineStore item : itemsCollection) {
            if (item.code == this.code) {
                found = true;
            }
        }

        if (!found) {
            itemsCollection.add(this);
        } else {
            System.out.println("This item already exists");
        }
    }

    public void buyProduct() {
        for (OnlineStore item : itemsCollection) {
            if (item.code == this.code) {
                if (item.count <= 0) {
                    System.out.println("The item is out of stock");
                } else {
                    --item.count;
                    System.out.println("The item has been bought successfully");
                }
            }
        }
    }

    public void getProductInfo() {
        System.out.println("The information about the product : ");
        System.out.println("Name : " + this.name);
        System.out.println("Price : " + this.price);
        System.out.println("Quantity : " + this.count);
        System.out.println("Code : " + this.code);
    }

    public void getProducts() {
        if (itemsCollection.isEmpty()) {
            System.out.println("There is no item in the list");
        } else {
            for (OnlineStore item : itemsCollection) {
                item.getProductInfo();
                System.out.println();
            }
        }
    }
}


class OnlineStoreMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the product : ");
        String name = scanner.nextLine();

        System.out.print("Enter the price of the product : ");
        double price = scanner.nextDouble();

        System.out.print("Enter the available quantity of the product : ");
        int count = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the name of the product : ");
        String name_2 = scanner.nextLine();

        System.out.print("Enter the price of the product : ");
        double price_2 = scanner.nextDouble();

        System.out.print("Enter the available quantity of the product : ");
        int count_2 = scanner.nextInt();
        scanner.nextLine();

        OnlineStore item = new OnlineStore(name, price, count);
        OnlineStore item_2 = new OnlineStore(name_2, price_2, count_2);

        int choice = 0;

        while (choice != 5) {
            System.out.println();
            System.out.println("What do you want to do ?");
            System.out.println("1) Add a product");
            System.out.println("2) Buy product");
            System.out.println("3) Get product's information");
            System.out.println("4) Get all products' information");
            System.out.println("5) Exit");

            System.out.print("Enter the number of the option : ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    item.addProduct();
                    item_2.addProduct();
                    System.out.println("Product added successfully");
                    System.out.println("-----------------------------------");
                    break;
                case 2:
                    item.buyProduct();
                    System.out.println("-----------------------------------");
                    break;
                case 3:
                    item.getProductInfo();
                    System.out.println("-----------------------------------");
                    break;
                case 4:
                    item.getProducts();
                    System.out.println("-----------------------------------");
                case 5:
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        }

        scanner.close();
    }
}