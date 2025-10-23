package lesson12.StreamAPI.StreamAPI;

import java.util.Comparator;
import java.util.List;


// Delete duplicated and sort the list out by lengths of the words ( stream API )
public class Task_5 {
    public static void main(String[] args) {
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");

        List<String> noDubAndSorted = input.stream().distinct().sorted(Comparator.comparing(String::length)).toList();

        for (String word : noDubAndSorted) {
            System.out.print(word + " ");
        }
    }
}
