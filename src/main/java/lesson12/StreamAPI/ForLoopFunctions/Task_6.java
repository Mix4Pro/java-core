package lesson12.StreamAPI.ForLoopFunctions;

import java.util.HashMap;
import java.util.List;

// Turn the value of a list into map -> value : length of the value
public class Task_6 {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "kiwi");
        HashMap<String, Integer> fruitsMap = new HashMap<>();

        if (!fruits.isEmpty()) {
            for (String fruit : fruits) {
                fruitsMap.put(fruit, fruit.length());
            }

            System.out.println(fruitsMap);
        } else {
            System.out.println("List of fruits is empty");
        }
    }
}
