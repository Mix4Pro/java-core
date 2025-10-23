package lesson11.Project_2;

public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(6);

        for (int i = 0; i < 10; i++) {
            int task_id = i + 1;

            System.out.println("ID : " + task_id + " works on : " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000); // имитация работы
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }

        try {
            Thread.sleep(3000);
            System.out.println("Pool exited");
            threadPool.shutdown();
        } catch (InterruptedException e) {
            System.out.println("The ending was interrupted");
        }

    }
}
