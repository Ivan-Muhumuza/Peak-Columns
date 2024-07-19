import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        int a = 0, b = 0;

        // Loop until valid input is obtained for the dimensions of the matrix
        while (true) {
            try {
                // Prompt user to enter the number of rows for matrix A
                System.out.print("Enter the number of rows for matrix A: ");
                a = scanner.nextInt();
                // Prompt user to enter the number of columns for matrix A
                System.out.print("Enter the number of columns for matrix A: ");
                b = scanner.nextInt();
                break; // Break the loop if input is valid
            } catch (InputMismatchException e) {
                // Handle invalid input for matrix dimensions
                System.out.println("Invalid input. Enter integer values only.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Initialize matrix A with the specified dimensions
        int[][] matrixA = new int[a][b];

        System.out.println("Enter the elements of matrix A:");

        // Loop through each element of the matrix to get user input
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                while (true) {
                    try {
                        // Read the next integer input for matrix element
                        matrixA[i][j] = scanner.nextInt();
                        break; // Break the loop if input is valid
                    } catch (InputMismatchException e) {
                        // Handle invalid input for matrix elements
                        System.out.println("Invalid input. Enter integer values only.");
                        scanner.next(); // Clear the invalid input
                    }
                }
            }
        }

        // Call the function to find and print peak columns
        findPeakColumns(matrixA);
    }

    /**
     * Finds and prints peak columns in the given matrix.
     * A peak column is defined as the column index where the maximum element
     * in a row is also the minimum element in its column.
     *
     * @param matrix the 2D array (matrix) to find peak columns in
     */
    public static void findPeakColumns(int[][] matrix) {
        int rows = matrix.length;  // Number of rows in the matrix
        int cols = matrix[0].length;  // Number of columns in the matrix
        boolean peakFound = false;  // Flag to check if any peak column is found

        // Loop through each row of the matrix
        for (int i = 0; i < rows; i++) {
            // Initialize the maximum element in the current row
            int maxInRow = matrix[i][0];
            int maxInRowIndex = 0;
            // Find the maximum element in the current row
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] > maxInRow) {
                    maxInRow = matrix[i][j];
                    maxInRowIndex = j;
                }
            }

            // Check if this maximum element is the minimum in its column
            boolean isMinInCol = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][maxInRowIndex] < maxInRow) {
                    isMinInCol = false;
                    break;
                }
            }

            // If it's a peak-column, print the position and value
            if (isMinInCol) {
                if (!peakFound) {
                    System.out.println();
                    System.out.println("Peak Column(s) found:");
                    peakFound = true;  // Set the flag as a peak column is found
                }
                System.out.println("(" + (i + 1) + "," + (maxInRowIndex + 1) + ") = " + maxInRow);
            }
        }

        // If no peak columns are found, print a message
        if (!peakFound) {
            System.out.println("No peak columns found.");
        }
    }
}
