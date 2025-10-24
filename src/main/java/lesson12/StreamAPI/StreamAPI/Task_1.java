package lesson12.StreamAPI.StreamAPI;

import java.util.List;

// Show even numbers' squares with streamAPI ( stream API )
public class Task_1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        if (!numbers.isEmpty()) {
            List<Integer> squaredNumbers = numbers.stream().filter(val -> val % 2 == 0).map(val -> val * val).toList();
            System.out.println(squaredNumbers);
        } else {
            System.out.println("List of numbers is empty");
        }
    }
}
