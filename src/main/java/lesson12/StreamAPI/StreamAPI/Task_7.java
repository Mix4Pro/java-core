package lesson12.StreamAPI.StreamAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Group the words with the same first letter ( stream API )
public class Task_7 {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");

        Map<Character, List<String>> groupedWords = names.stream().collect(Collectors.groupingBy(val -> val.charAt(0)));

        System.out.println(groupedWords);
    }
}
