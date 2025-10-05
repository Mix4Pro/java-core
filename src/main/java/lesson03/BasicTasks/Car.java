package lesson03.BasicTasks;

import java.util.Scanner;

class Car {
    private final String country;
    private final String model;
    private final int yearOfManufacture;

    Car (String country , String model , int yearOfManufacture) {
        this.country = country;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }


    public void printCarInfo() {
        System.out.println("Country : " + country);
        System.out.println("Model : " + model);
        System.out.println("yearOfManufacture : " + yearOfManufacture);
    }
}

class Task_3 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String country;
        String model;
        int yearOfManufacture;

        System.out.print("Please enter a country where the car was created : ");
        country = scanner.nextLine();

        System.out.print("Please enter a model of the car : ");
        model = scanner.nextLine();

        System.out.print("Please enter the year when the car was created : ");
        yearOfManufacture = scanner.nextInt();

        scanner.close();

        if(yearOfManufacture < 0){
            System.out.println("The year can't be less than 0");
        }else{
            Car newCar = new Car(country,model,yearOfManufacture);

            newCar.printCarInfo();
        }

    }
}