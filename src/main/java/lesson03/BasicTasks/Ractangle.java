package lesson03.BasicTasks;

import java.util.Scanner;

class Rectangle {
    private final double length;
    private final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }


    private boolean isValidSize() {
        return (this.length > 0 || this.width > 0);
    }

    public double calculateSquare() {
        if (isValidSize()) {
            return this.length * this.width;
        } else {
            System.out.println("Size is not valid");
            return -1;
        }
    }

    public double calculatePerimeter() {
        if (isValidSize()) {
            return (this.length + this.width) * 2;
        } else {
            System.out.println("Size is not valid");
            return -1;
        }
    }
}

class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length, width;

        System.out.print("Please enter the length : ");
        length = scanner.nextDouble();

        System.out.print("Please enter the width : ");
        width = scanner.nextDouble();


        scanner.close();

        Rectangle rectangle = new Rectangle(length, width);

        System.out.println("Square : " + rectangle.calculateSquare() + " Perimeter : " + rectangle.calculatePerimeter());
    }
}