import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        int rows = 0, cols = 0; // Initialize variables for the number of rows and columns

        // Loop until valid input is obtained for the dimensions of the matrix
        while (true) {
            try {
                System.out.print("Enter the number of rows for the matrix: ");
                rows = scanner.nextInt(); // Read the number of rows
                System.out.print("Enter the number of columns for the matrix: ");
                cols = scanner.nextInt(); // Read the number of columns
                break; // Exit the loop if valid input is obtained
            } catch (InputMismatchException e) {
                // Handle invalid input
                System.out.println("Invalid input. Enter integer values only.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Create a matrix object with the specified number of rows and columns
        Matrix matrix = new Matrix(rows, cols);
        // Prompt the user to input the elements of the matrix
        matrix.inputElements();

        // Create a PeakColumnFinder object
        PeakColumnFinder peakColumnFinder = new PeakColumnFinder();
        // Find and print the peak columns in the matrix
        peakColumnFinder.findPeakColumns(matrix);
    }
}
