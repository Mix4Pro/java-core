package lesson12.StreamAPI.ForLoopFunctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Get all words from the list of sentences
public class Task_9 {
    public static void main(String[] args) {
        List<String> sentences = List.of("Java is cool", "Streams are powerful");
        ArrayList<String> wordCollection = new ArrayList<>();

        for (String sen : sentences) {
            String[] tokens = sen.split(" ");
            Collections.addAll(wordCollection, tokens);
        }

        System.out.println(wordCollection);
    }
}
