package lesson11.Project_2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class ThreadPool {
    private final int threadsCount;
    private final BlockingQueue<Runnable> taskCollection;
    private volatile boolean status = true;
    private final Task[] taskArray;

    ThreadPool(int threadsCount) {
        this.threadsCount = threadsCount;
        this.taskArray = new Task[threadsCount];
        this.taskCollection = new LinkedBlockingQueue<>();

        for (int i = 0; i < threadsCount; i++) {
            taskArray[i] = new Task("Task : " + i);
            taskArray[i].start();
        }
    }

    public void submit(Runnable task) {
        if (status) {
            try {
                taskCollection.put(task);
            } catch (InterruptedException e) {
                System.out.println("The task was interrupted");
            }
        } else {
            System.out.println("Thread pull is stopped");
        }
    }

    public void shutdown() {
        status = false;
        for (Task task : taskArray) {
            task.interrupt();
        }
    }

    private class Task extends Thread {
        Task(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!taskCollection.isEmpty() || status) {
                try {
                    Runnable task = taskCollection.take();
                    task.run();
                } catch (InterruptedException e) {
                    if (taskCollection.isEmpty() && !status) {
                        break;
                    }
                }
            }

            System.out.println("Task " + getName() + " ended");
        }
    }
}
