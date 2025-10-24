package lesson12.FunctionalInterfaces;

import java.util.List;
import java.util.function.Consumer;

// forEach that can display all the elements of the List
public class Task_13 {
    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        if (consumer == null) {
            System.out.println("Consumer is null");

            return;
        }
        if (list == null) {
            System.out.println("List is null");

            return;
        }

        for (T list_el : list) {
            consumer.accept(list_el);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Consumer<Integer> showNumbers = (val) -> System.out.print(val + " ");

        forEach(numbers, showNumbers);
    }
}
