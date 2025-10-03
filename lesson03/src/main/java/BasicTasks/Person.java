package BasicTasks;

import java.util.Scanner;

class Person {
    private final String name;
    private int age;

    Person() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a name : ");
        this.name = scanner.nextLine();
        System.out.print("Please enter your age : ");
        this.age = scanner.nextInt();
        scanner.close();
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
        Person person = new Person();
        person.introduce();
    }
}