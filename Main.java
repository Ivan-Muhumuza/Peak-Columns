import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows and columns for matrix A: ");

        int a = 0, b = 0;

        a = scanner.nextInt();
        b = scanner.nextInt();

        int[][] matrixA = new int[a][b];

        System.out.println("Enter the elements of matrix A:");

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                while (true) {
                    try {
                        matrixA[i][j] = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Enter integer values only.");
                        return;
                    }
                }
            }
        }

        findPeakColumns(matrixA);
    }

    public static void findPeakColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            /* Find the maximum element in the current row */
            int maxInRow = matrix[i][0];
            int maxInRowIndex = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] > maxInRow) {
                    maxInRow = matrix[i][j];
                    maxInRowIndex = j;
                }
            }

            /* Check if this maximum element is the minimum in its column */
            boolean isMinInCol = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][maxInRowIndex] < maxInRow) {
                    isMinInCol = false;
                    break;
                }
            }

            /* If it's a peak-column, print the position and value */
            if (isMinInCol) {

                System.out.println();
                System.out.println("Peak Column is: ");
                System.out.println("(" + (i + 1) + "," + (maxInRowIndex + 1) + ") = " + maxInRow);
            }
        }
    }
}
