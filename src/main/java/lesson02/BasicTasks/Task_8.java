package lesson02.BasicTasks;


// Find a number that is divisible by 7 and greater than 1000
class Task_8 {
    public static void main(String[] args) {
        int i = 999;
        while (i % 7 != 0) { // To check if "i" can be divided by 7 without a remainder
            i += 2; // Add 2 to i , since prime numbers are odd , there is no need to do i++ , it is better to skip even numbers
        }

        System.out.println(i);
    }
}