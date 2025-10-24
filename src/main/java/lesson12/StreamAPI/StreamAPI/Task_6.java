package lesson12.StreamAPI.StreamAPI;

import java.util.HashMap;
import java.util.List;

// Turn the value of a list into map -> value : length of the value ( stream API )
public class Task_6 {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "kiwi");

        HashMap<String, Integer> wordLength = new HashMap<>();

        fruits.stream().forEach(val -> wordLength.put(val, val.length()));

        System.out.println(wordLength);
    }
}
