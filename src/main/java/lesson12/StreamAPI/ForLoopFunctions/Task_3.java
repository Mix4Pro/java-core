package lesson12.StreamAPI.ForLoopFunctions;

import java.util.List;

// Find max and min values
public class Task_3 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 2, 33, 4, 25);

        if (!nums.isEmpty()) {
            int max = nums.get(0);
            int min = nums.get(0);

            for (int i = 1; i < nums.size(); i++) {
                if (max < nums.get(i)) max = nums.get(i);
            }

            for (int i = 1; i < nums.size(); i++) {
                if (min > nums.get(i)) min = nums.get(i);
            }

            System.out.println("Max : " + max);
            System.out.println("Min : " + min);
        } else {
            System.out.println("The list of elements is empty");
        }

    }
}
