package lesson11.Project_1;

import java.util.Queue;
import java.util.Scanner;

public class Publisher implements Runnable {
    private final Queue<String> wordCollection;
    private final boolean[] status;

    Publisher(Queue<String> wordCollection, boolean[] status) {
        this.wordCollection = wordCollection;
        this.status = status;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("If you want to leave , enter \"exit\" \n");
            System.out.print("Enter your word : ");

            String word = scanner.nextLine();

            synchronized (wordCollection) {
                if (word.equals("exit")) {
                    this.status[0] = false;
                    wordCollection.notifyAll();
                    break;
                }

                wordCollection.add(word);

                System.out.println("The word is added");

                wordCollection.notifyAll();
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("The sleep was interrupted");
            }
        }

        System.out.println("Publisher exited");
    }
}
