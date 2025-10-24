package lesson12.StreamAPI.ForLoopFunctions;

import java.util.List;

// Group the words with the same first letter
public class Task_7 {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");

        if (!names.isEmpty()) {
            char letter_before = 'A';
            for (int i = 0; i < names.size(); i++) {
                char first_letter = names.get(i).charAt(0);
                if (i == 0) {
                    System.out.println("Group " + first_letter);
                    letter_before = first_letter;
                }

                if (first_letter != letter_before) {
                    System.out.println("Group " + first_letter);
                    letter_before = first_letter;
                }

                System.out.println("\t" + names.get(i));
            }
        } else {
            System.out.println("List of names is empty");
        }
    }
}
