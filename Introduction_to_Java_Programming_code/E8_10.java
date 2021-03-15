/*
  Write a program that randomly fills in 0s and 1s into a 4-by-4 matrix,
  prints the matrix, and finds the first row and column with the most 1s.
*/

public class E8_10 {
  public static void main(String[] args) {
    int[][] matrix = randomMatrix(4, 4);

    displayMatrix(matrix);

    System.out.println("Largest Row: " + largestRow(matrix));
    System.out.println("Largest Column: " + largestColumn(matrix));
  }

  public static void displayMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
  }

  public static int[][] randomMatrix(int row, int col) {
    int[][] matrix = new int[row][col];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = (int)(Math.random() * 2);
      }
    }
    return matrix;
  }

  public static int largestColumn(int[][] matrix) {
    // first column defaults to largest index
    int largestIndex = 0;
    // get sum of first column
    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      sum += matrix[0][i];
    }

    // go through the rest of the matrix and find the largest index
    for (int i = 1; i < matrix[0].length; i++) {
      int tempSum = 0;
      for (int j = 0; j < matrix.length; j++) {
        tempSum += matrix[j][i];
      }

      if (tempSum > sum) {
        sum = tempSum;
        largestIndex = i;
      }
    }

    return largestIndex;
  }

  public static int largestRow(int[][] matrix) {
    // first row defaults to largest index
    int largestIndex = 0;
    // get some of first row
    int sum = 0;
    for (int i = 0; i < matrix[0].length; i++) {
      sum += matrix[0][i];
    }

    // go through the rest of the matrix and find the largest index
    for (int i = 1; i < matrix.length; i++) {
      int tempSum = 0;
      for (int j = 0; j < matrix[i].length; j++) {
        tempSum += matrix[i][j];
      }

      if (tempSum > sum) {
        sum = tempSum;
        largestIndex = i;
      }
    }

    return largestIndex;
  }
}
