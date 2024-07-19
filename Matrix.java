import java.util.Scanner;
import java.util.InputMismatchException;

public class Matrix {
    // Private fields to store the matrix data and its dimensions
    private int[][] data;
    private int rows;
    private int cols;

    // Constructor to initialize the matrix with the specified number of rows and columns
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new int[rows][cols]; // Allocate memory for the matrix
    }

    // Method to input elements into the matrix
    public void inputElements() {
        Scanner scanner = new Scanner(System.in); // Scanner object to read input from the console
        System.out.println("Enter the elements of the matrix:");

        // Loop through each cell of the matrix to input its value
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) { // Loop to ensure valid integer input
                    try {
                        data[i][j] = scanner.nextInt(); // Read integer input
                        break; // Exit the loop if input is valid
                    } catch (InputMismatchException e) {
                        // Handle invalid input by displaying an error message
                        System.out.println("Invalid input. Enter integer values only.");
                        scanner.next(); // Clear the invalid input from the scanner buffer
                    }
                }
            }
        }
    }

    // Getter method to return the number of rows in the matrix
    public int getRows() {
        return rows;
    }

    // Getter method to return the number of columns in the matrix
    public int getCols() {
        return cols;
    }

    // Method to get the element at the specified row and column
    public int getElement(int row, int col) {
        return data[row][col];
    }
}
