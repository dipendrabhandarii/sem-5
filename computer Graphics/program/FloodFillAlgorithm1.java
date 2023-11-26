import java.util.Arrays;

public class FloodFillAlgorithm1 {
    public static void main(String[] args) {
        int[][] image = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        int startX = 1;
        int startY = 1;
        int width = 3;
        int height = 2;
        int newColor = 1;

        floodFillRectangle(image, startX, startY, width, height, newColor);

        System.out.println("Image after Flood Fill:");
        printImage(image);
    }

    public static void floodFillRectangle(int[][] image, int startX, int startY, int width, int height, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[startX][startY];

        // If the starting point is already of the new color, no need to fill
        if (oldColor == newColor) {
            return;
        }

        // Call the recursive helper function
        floodFillHelper(image, startX, startY, width, height, rows, cols, oldColor, newColor);
    }

    private static void floodFillHelper(int[][] image, int row, int col, int width, int height, int rows, int cols, int oldColor, int newColor) {
        // Base cases for recursion
        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != oldColor) {
            return;
        }

        // Update the current pixel with the new color
        image[row][col] = newColor;

        // Recursively fill the neighboring pixels within the rectangle
        floodFillHelper(image, row - 1, col, width, height, rows, cols, oldColor, newColor); // Up
        floodFillHelper(image, row + 1, col, width, height, rows, cols, oldColor, newColor); // Down
        floodFillHelper(image, row, col - 1, width, height, rows, cols, oldColor, newColor); // Left
        floodFillHelper(image, row, col + 1, width, height, rows, cols, oldColor, newColor); // Right
    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
