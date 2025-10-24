package lesson12.FunctionalInterfaces;

import java.util.function.UnaryOperator;

// Add "!!!" to the end of the string
public class Task_10 {
    public static void main(String[] args) {
        UnaryOperator<String> addExclamationMarks = (val) -> val + "!!!";

        String addExclamationMarksResult = addExclamationMarks.apply("Something");

        System.out.println(addExclamationMarksResult);
    }
}
