package lesson05.Part_1;

public abstract class Person {
    private final String name;
    private final String email;
    private final int age;

    Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public abstract String role();

    // Getters
    public String getName() {return this.name;}

    public String getEmail() {return this.email;}

    public int getAge() {return this.age;}
}