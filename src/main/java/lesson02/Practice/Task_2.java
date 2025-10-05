package lesson02.Practice;



// Display multiplication table
class Task_2 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i * j >= 10) {
                    System.out.printf("%d x %d = %d  ", j, i, i * j);
                } else {
                    System.out.printf("%d x %d = %d   ", j, i, i * j);
                }
                if (j == 9) {
                    System.out.println();
                }
            }
        }
    }
}