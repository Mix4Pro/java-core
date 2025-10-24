package lesson12.FunctionalInterfaces;

import java.util.function.Consumer;


// Print the text in uppercase
public class Task_4 {
    public static void main(String[] args) {
        Consumer<String> upperCaseVersion = (val) -> System.out.println(val.toUpperCase());

        upperCaseVersion.accept("Something like a text");
    }
}
