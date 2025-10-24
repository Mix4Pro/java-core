package lesson12.StreamAPI.StreamAPI;

import java.util.List;
import java.util.stream.Collectors;

// Make a line of names separated by commas ( stream API )
public class Task_8 {
    public static void main(String[] args) {
        List<String> names = List.of("Tom", "Jerry", "Spike");

        String line = names.stream().collect(Collectors.joining(", "));

        System.out.println(line);
    }
}
