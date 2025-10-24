package lesson12.StreamAPI.ForLoopFunctions;

import java.util.ArrayList;
import java.util.List;


// Show even numbers' squares
public class Task_1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        ArrayList<Integer> numbersSquareCollection = new ArrayList<>();

        if (!numbers.isEmpty()) {
            for (int num : numbers) {
                if (num % 2 == 0) {
                    numbersSquareCollection.add(num * num);
                }
            }

            for (int num : numbersSquareCollection) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("List of numbers is empty");
        }
    }
}
