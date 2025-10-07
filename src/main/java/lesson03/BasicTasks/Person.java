package lesson03.BasicTasks;

import java.util.Scanner;

class Person {
    private final String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        if (this.age < 0) {
            System.out.println("Your age is not real");
            this.age = -1;
        } else {
            System.out.println("Your name is " + this.name + " and you are " + this.age + " years old");
        }
    }
}

class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name;
        int age;

        System.out.print("Please enter a name : ");
        name = scanner.nextLine();

        System.out.print("Please enter your age : ");
        age = scanner.nextInt();

        scanner.close();

        Person person = new Person(name, age);
        person.introduce();
    }
}