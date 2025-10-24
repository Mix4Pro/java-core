package lesson12.StreamAPI.StreamAPI;

import java.util.Arrays;
import java.util.List;


// Get all words from the list of sentences ( stream API )
public class Task_9 {
    public static void main(String[] args) {
        List<String> sentences = List.of("Java is cool", "Streams are powerful");

        List<String> wordsCollection = sentences.stream().flatMap(val -> Arrays.stream(val.split(" "))).toList();

        System.out.println(wordsCollection);
    }
}
