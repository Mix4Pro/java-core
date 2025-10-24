package lesson12.FunctionalInterfaces;

import java.util.function.Predicate;


// Predicate that cheks whether the string has more than 3 characters
public class Task_1 {
    public static void main(String[] args) {
        Predicate<String> moreThanThreeCharacters = (val) -> val.length() > 3;

        boolean result = moreThanThreeCharacters.test("Something");

        System.out.println(result);
    }
}
