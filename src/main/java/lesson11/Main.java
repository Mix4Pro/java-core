package lesson11;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> wordCollection = new LinkedList<>();


        // Array to send not the copy , but the variable itself
        boolean[] status = {true};

        Thread publisher_td = new Thread(new Publisher(wordCollection, status));
        Thread subscriber = new Thread(new Subscriber(wordCollection, status));

        publisher_td.start();

        subscriber.start();

        try {
            publisher_td.join();
            subscriber.join();
        } catch (InterruptedException e) {
            System.out.println("The joining was interrupted");
        }

        System.out.println("Program exited");
    }
}
