package lesson12.FunctionalInterfaces;

import java.util.function.Function;


// Return the length of the string
public class Task_2 {
    public static void main(String[] args) {
        Function<String, Integer> line = (val) -> val.length();

        int length = line.apply("Something");

        System.out.println(length);
    }
}
