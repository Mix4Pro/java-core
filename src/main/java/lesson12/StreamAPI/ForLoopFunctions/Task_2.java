package lesson12.StreamAPI.ForLoopFunctions;

import java.util.List;

// Show words that have more than 5 letter in them
public class Task_2 {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");

        if (!words.isEmpty()) {
            int counter = 0;
            for (String word : words) {
                if (word.length() > 5) {
                    counter++;
                }
            }

            System.out.println("Total number of words that have more than 5 characters : " + counter);
        } else {
            System.out.println("The list of words is empty");
        }
    }

}
