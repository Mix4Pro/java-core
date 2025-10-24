package lesson12.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Filter analogue of filter in stream API

public class Task_11 {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {

        if (predicate == null) {
            System.out.println("Predicate is null");
            return null;
        }

        if (list == null) {
            System.out.println("The list is null");
            return null;
        }

        List<T> filtered = new ArrayList<>();

        for (T list_el : list) {
            if (predicate.test(list_el)) {
                filtered.add(list_el);
            }
        }

        return filtered;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);

        Predicate<Integer> isBiggerThanTen = (val) -> val > 10;

        List<Integer> listOfNumbersBiggerThanTen = filter(numbers, isBiggerThanTen);

        for (int list_el : listOfNumbersBiggerThanTen) {
            System.out.print(list_el + " ");
        }
    }
}
