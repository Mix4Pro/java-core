package BasicTasks;

import java.util.Scanner;

class Rectangle {
    private final double length;
    private final double width;

    Rectangle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the length : ");
        this.length = scanner.nextDouble();

        System.out.print("Please enter the width : ");
        this.width = scanner.nextDouble();


        scanner.close();
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
        Rectangle rectangle = new Rectangle();

        System.out.println("Square : " + rectangle.calculateSquare() + " Perimeter : " + rectangle.calculatePerimeter());
    }
}