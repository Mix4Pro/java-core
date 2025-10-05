package lesson02.BasicTasks;

//Display triangles
class Task_10 {
    public static void main(String[] args) {
        int left = 1;
        int right = 4;
        while (right - left != -5) { // The first pair of triangles

            for (int i = 0; i < left; i++) { // Display triangle #1 from top to bottom
                System.out.print("*");
            }

            System.out.print("   "); // Space

            for (int j = right; j > 0; j--) { // Display triangle #2 from bottom to top
                System.out.print("*");
            }

            System.out.println(); // Switch to the next line

            left++;
            right--;
        }


        left = 1;
        right = 4;

        System.out.println();


        while (right - left != -5) { // The second pair of triangles ( reversed )

            for (int j = right; j > 0; j--) { // Display triangle #2 from top to bottom
                System.out.print("*");
            }

            System.out.print("   "); // Space

            for (int i = 0; i < left; i++) { // Display triangle #1 from bottom to top
                System.out.print("*");
            }

            System.out.println(); // Switch to the next line

            left++;
            right--;
        }
    }
}