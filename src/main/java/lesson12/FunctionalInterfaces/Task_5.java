package lesson12.FunctionalInterfaces;

import java.util.function.BiFunction;

// Return the sum of two numbers
public class Task_5 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sumOfNumbers = (val_1, val_2) -> val_1 + val_2;

        int sum = sumOfNumbers.apply(1, 2);

        System.out.println(sum);
    }
}
