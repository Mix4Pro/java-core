package lesson02.BasicTasks;

// Comment for a pull

// Display all numbers up to 100 ( every 10 numbers should be displayed in a row )
class Task_1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.println(i);
            } else {
                System.out.print(i + " ");
            }
        }
    }
}