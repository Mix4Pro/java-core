package lesson12.StreamAPI.StreamAPI;

import java.util.List;


// Show words that have more than 5 letter in them ( stream API )
public class Task_2 {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");


        List<String> bigWords = words.stream().filter(val -> val.length() > 5).toList();

        System.out.println("Total number of words that have more than 5 characters : " + bigWords.size());
    }
}
