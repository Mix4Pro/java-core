package lesson11;

import java.util.Queue;

public class Subscriber implements Runnable {
    private final Queue<String> wordCollection;
    private final boolean[] status;

    Subscriber(Queue<String> wordCollection, boolean[] status) {
        this.wordCollection = wordCollection;
        this.status = status;
    }

    @Override
    public void run() {
        while (status[0]) {
            synchronized (wordCollection) {
                if (wordCollection.isEmpty() && status[0]) {
                    try {
                        wordCollection.wait();
                    } catch (InterruptedException e) {
                        System.out.println("The wait was interrupted");
                    }
                }

                if (!wordCollection.isEmpty() && status[0]) {
                    String word = wordCollection.poll();

                    System.out.println("Entered : " + word);
                } else {
                    break;
                }
            }
        }

        System.out.println("Subscriber exited");
    }
}
