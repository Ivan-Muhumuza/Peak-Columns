public class PeakColumnFinder {

    /**
     * Finds and prints peak columns in the given matrix.
     * A peak column is defined as the column index where the maximum element
     * in a row is also the minimum element in its column.
     *
     * @param matrix the 2D array (matrix) to find peak columns in
     */
    public void findPeakColumns(Matrix matrix) {
        int rows = matrix.getRows(); // Get the number of rows in the matrix
        int cols = matrix.getCols(); // Get the number of columns in the matrix
        boolean peakFound = false; // Flag to check if any peak column is found

        // Iterate over each row in the matrix
        for (int i = 0; i < rows; i++) {
            // Initialize the maximum element in the current row
            int maxInRow = matrix.getElement(i, 0);
            int maxInRowIndex = 0;

            // Iterate over each column in the current row to find the maximum element
            for (int j = 1; j < cols; j++) {
                if (matrix.getElement(i, j) > maxInRow) {
                    maxInRow = matrix.getElement(i, j);
                    maxInRowIndex = j;
                }
            }

            // Check if the maximum element in the current row is the minimum in its column
            boolean isMinInCol = true;
            for (int k = 0; k < rows; k++) {
                if (matrix.getElement(k, maxInRowIndex) < maxInRow) {
                    isMinInCol = false; // If any element in the column is less than maxInRow, set flag to false
                    break; // No need to check further, break the loop
                }
            }

            // If the maximum element in the row is also the minimum in its column, it's a peak column
            if (isMinInCol) {
                if (!peakFound) {
                    System.out.println();
                    System.out.println("Peak Column(s) found:"); // Print header once if peak column is found
                    peakFound = true;
                }
                // Print the position (1-based index) and value of the peak column
                System.out.println("(" + (i + 1) + "," + (maxInRowIndex + 1) + ") = " + maxInRow);
            }
        }

        // If no peak columns were found, print a message indicating so
        if (!peakFound) {
            System.out.println("No peak columns found.");
        }
    }
}
