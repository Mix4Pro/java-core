package lesson12.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// Map method that turn a string list into list of strings' lengths
public class Task_12 {
    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {

        if (mapper == null) {
            System.out.println("Function is null");

            return null;
        }
        if (list == null) {
            System.out.println("List is null");
            return null;
        }


        List<R> mappedCollection = new ArrayList<>();

        for (T list_el : list) {
            R temp_res = mapper.apply(list_el);
            mappedCollection.add(temp_res);
        }

        return mappedCollection;
    }

    public static void main(String[] args) {
        List<String> textCollection = List.of("Something", "Some other thing", "Something like a text");

        Function<String, Integer> countTextLength = (val) -> val.length();

        List<Integer> mappedCollection = map(textCollection, countTextLength);

        System.out.println(mappedCollection);

    }
}
