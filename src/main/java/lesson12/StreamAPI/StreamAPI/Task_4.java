package lesson12.StreamAPI.StreamAPI;

import java.util.List;

// Average mean of characters in the words ( stream API )
public class Task_4 {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        double avg_letters = names.stream().mapToInt(String::length).average().orElse(0);

        System.out.println("Average letters : " + avg_letters);
    }
}
