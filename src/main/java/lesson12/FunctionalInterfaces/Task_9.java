package lesson12.FunctionalInterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

// Multiply two numbers , then turn it into a string
public class Task_9 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;

        BiFunction<Integer, Integer, String> doBoth = multiply.andThen(toStr);

        String doBothResult = doBoth.apply(4, 10);

        System.out.println(doBothResult);
    }
}
