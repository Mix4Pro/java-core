package lesson12.FunctionalInterfaces;

import java.util.function.Function;


// Trim the line , then turn all characters into uppercase
public class Task_6 {
    public static void main(String[] args) {
        Function<String, String> trimAndConvertToUpperCase = (val) -> val.trim().toUpperCase();

        String line = trimAndConvertToUpperCase.apply("            Something ayoooo                 ");

        System.out.println(line);
    }
}
