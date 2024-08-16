package Neo;
import java.util.*;
public class Matrix {
    private final int[][] matrix;

    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.trim().split("\n");
        int numRows = rows.length;
        int numCols = rows[0].split(" ").length;
        matrix = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            String[] values = rows[i].split(" ");
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        // Adjust for 1-based index
        if (rowNumber <= 0 || rowNumber > matrix.length) {
            throw new IllegalArgumentException("Invalid row number");
        }
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        if (columnNumber <= 0 || columnNumber > matrix[0].length) {
            throw new IllegalArgumentException("Invalid column number");
        }
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnNumber - 1];
        }
        return column;
    }

}
