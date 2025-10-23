package lesson12.StreamAPI.ForLoopFunctions;

import java.util.ArrayList;
import java.util.List;

// Show words that have more than 5 letter in them
public class Task_2 {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        ArrayList<String> wordsWithAtLeastFiveCharacters = new ArrayList<>();

        if (!words.isEmpty()) {
            for (String word : words) {
                if (word.length() > 5) {
                    wordsWithAtLeastFiveCharacters.add(word);
                }
            }

            for (String word : wordsWithAtLeastFiveCharacters) {
                System.out.print(word + " ");
            }
        } else {
            System.out.println("The list of words is empty");
        }
    }

}
