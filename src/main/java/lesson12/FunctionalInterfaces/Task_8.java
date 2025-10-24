package lesson12.FunctionalInterfaces;

import java.util.function.Predicate;


// Checks whether the number is even or not . And checks if the number is positive or not ?
public class Task_8 {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (val) -> val % 2 == 0;
        Predicate<Integer> isPositive = (val) -> val > 0;

        boolean even = isEven.test(10);
        boolean positive = isPositive.test(100);

        System.out.println("Even : " + even);
        System.out.println("Positive : " + positive);
    }
}
