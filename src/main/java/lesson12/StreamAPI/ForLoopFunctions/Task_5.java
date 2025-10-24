package lesson12.StreamAPI.ForLoopFunctions;

import java.util.ArrayList;
import java.util.List;

// Delete duplicated and sort the list out by lengths of the words
public class Task_5 {
    public static void main(String[] args) {
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        List<String> noDublicatesList = new ArrayList<>();

        for (String input_word : input) {
            boolean state = false;
            for (String noDub_word : noDublicatesList) {
                if (input_word.equals(noDub_word)) {
                    state = true;
                    break;
                }
            }

            if (!state) {
                noDublicatesList.add(input_word);
            }
        }

        for (int i = 0; i < noDublicatesList.size() - 1; i++) {
            for (int j = 1; j < noDublicatesList.size(); j++) {
                if (noDublicatesList.get(i).length() > noDublicatesList.get(j).length()) {
                    String temp = noDublicatesList.get(i);
                    noDublicatesList.set(i, noDublicatesList.get(j));
                    noDublicatesList.set(j, temp);
                }
            }
        }

        for (String word : noDublicatesList) {
            System.out.print(word + " ");
        }
    }
}
