package lesson12.StreamAPI.ForLoopFunctions;

import java.util.List;

// Make a line of names separated by commas
public class Task_8 {
    public static void main(String[] args) {
        List<String> names = List.of("Tom", "Jerry", "Spike");

        if (!names.isEmpty()) {
            String line = names.getFirst();

            for (int i = 1; i < names.size(); i++) {
                line = line.concat("," + names.get(i));
            }

            System.out.println(line);
        } else {
            System.out.println("List of names is empty");
        }

    }
}
