package lesson12.FunctionalInterfaces;


import java.util.function.Consumer;

// Show the line , then show the length , then do it both with andThen
public class Task_7 {
    public static void main(String[] args) {
        Consumer<String> printTheLine = (val) -> System.out.println(val);

        Consumer<String> printTheLengthOfTheLine = (val) -> System.out.println(val.length());

        Consumer<String> doBoth = printTheLine.andThen(printTheLengthOfTheLine);


        doBoth.accept("Something");
    }
}
