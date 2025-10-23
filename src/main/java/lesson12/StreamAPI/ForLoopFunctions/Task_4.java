package lesson12.StreamAPI.ForLoopFunctions;

import java.util.List;

// Average mean of characters in the words
public class Task_4 {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        if (!names.isEmpty()) {
            int total_letters = 0;

            for (String name : names) {
                total_letters += name.length();
            }

            double avg_letters = (double) total_letters / names.size();

            System.out.println("Average letters of the words : " + avg_letters);
        } else {
            System.out.println("The list of names is empty");
        }

    }
}
