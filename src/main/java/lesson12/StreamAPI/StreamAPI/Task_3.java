package lesson12.StreamAPI.StreamAPI;

import java.util.List;

// Find max and min values ( stream API )
public class Task_3 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 2, 33, 4, 25);

        int max = nums.stream().max(Integer::compare).get();
        int min = nums.stream().min(Integer::compare).get();

        System.out.println("Max : " + max);
        System.out.println("Min : " + min);
    }
}
